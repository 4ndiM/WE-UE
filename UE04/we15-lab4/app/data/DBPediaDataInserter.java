package data;

import at.ac.tuwien.big.we.dbpedia.api.DBPediaService;
import at.ac.tuwien.big.we.dbpedia.api.SelectQueryBuilder;
import at.ac.tuwien.big.we.dbpedia.vocabulary.DBPedia;
import at.ac.tuwien.big.we.dbpedia.vocabulary.DBPediaOWL;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.sparql.vocabulary.FOAF;
import com.hp.hpl.jena.vocabulary.DCTerms;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;
import models.Answer;
import models.Category;
import models.JeopardyDAO;
import models.Question;

import java.util.List;
import java.util.Locale;

public class DBPediaDataInserter {

    public static Boolean insertData() {

        if(!DBPediaService.isAvailable())
            return false;

        Category category = new Category();
        category.setNameEN("Geography");
        category.setNameDE("Geographie");

        // Question 1
        Resource capitalsInEurope = DBPediaService.loadStatements(DBPedia.createResource("Category:Capitals_in_Europe"));
        Resource austria = DBPediaService.loadStatements(DBPedia.createResource("Austria"));
        SelectQueryBuilder query = DBPediaService.createQueryBuilder()
                .setLimit(1)
                .addWhereClause(RDF.type, DBPediaOWL.PopulatedPlace)
                .addPredicateExistsClause(FOAF.name)
                .addWhereClause(DCTerms.subject, capitalsInEurope)
                .addWhereClause(DBPediaOWL.country, austria)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH);
        String right = query.toQueryString();

        query.setLimit(5);
        query.removeWhereClause(DBPediaOWL.country, austria);
        query.addMinusClause(DBPediaOWL.country, austria);
        String wrong = query.toQueryString();

        Question capitalOfAustria;
        if((capitalOfAustria = buildQuestion("Hauptstadt von Österreich", "Capital of Austria", 10, right, wrong)) != null)
            category.addQuestion(capitalOfAustria);

        // Question 2
        Resource statesOfAustria = DBPediaService.loadStatements(DBPedia.createResource("States_of_Austria"));
        Resource germany = DBPediaService.loadStatements(DBPedia.createResource("Germany"));
        query = DBPediaService.createQueryBuilder()
                .setLimit(3)
                .addWhereClause(RDF.type, DBPediaOWL.PopulatedPlace)
                .addPredicateExistsClause(FOAF.name)
                .addWhereClause(DBPediaOWL.type, statesOfAustria)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH);
        right = query.toQueryString();

        query.setOffset(6);
        query.removeWhereClause(DBPediaOWL.type, statesOfAustria);
        query.addMinusClause(DBPediaOWL.type, statesOfAustria);
        query.addWhereClause(DBPediaOWL.country, austria);
        wrong = query.toQueryString();

        Question statesOfAustriaQ;
        if((statesOfAustriaQ = buildQuestion("Österreichische Bundesländer", "States of Austria", 20, right, wrong)) != null)
            category.addQuestion(statesOfAustriaQ);

        // Question 3
        Resource france = DBPediaService.loadStatements(DBPedia.createResource("France"));
        query = DBPediaService.createQueryBuilder()
                .setLimit(1)
                .addWhereClause(RDF.type, DBPediaOWL.PopulatedPlace)
                .addPredicateExistsClause(FOAF.name)
                .addWhereClause(DCTerms.subject, capitalsInEurope)
                .addWhereClause(DBPediaOWL.country, france)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH);
        right = query.toQueryString();

        query.setLimit(5);
        query.removeWhereClause(DBPediaOWL.country, france);
        query.addMinusClause(DBPediaOWL.country, france);
        wrong = query.toQueryString();

        Question capitalOfFrance;
        if((capitalOfFrance = buildQuestion("Hauptstadt von Frankreich", "Capital of France", 30, right, wrong)) != null)
            category.addQuestion(capitalOfFrance);

        // Question 4
        Resource countriesInEurope = DBPediaService.loadStatements(DBPedia.createResource("Category:Countries_in_Europe"));
        Resource countriesInAfrica = DBPediaService.loadStatements(DBPedia.createResource("Category:Countries_in_Africa"));
        query = DBPediaService.createQueryBuilder()
                .setLimit(4)
                .addWhereClause(RDF.type, DBPediaOWL.Country)
                .addPredicateExistsClause(FOAF.name)
                .addWhereClause(DCTerms.subject, countriesInEurope)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH);
        right = query.toQueryString();

        query.setLimit(2);
        query.setOffset(2);
        query.removeWhereClause(DCTerms.subject, countriesInEurope);
        query.addMinusClause(DCTerms.subject, countriesInEurope);
        query.addWhereClause(DCTerms.subject, countriesInAfrica);
        wrong = query.toQueryString();

        Question countriesOfEuropeQ;
        if((countriesOfEuropeQ = buildQuestion("Europäische Länder", "Countries in Europe", 40, right, wrong)) != null)
            category.addQuestion(countriesOfEuropeQ);

        //Question 5
        Resource statesOfUsa = DBPediaService.loadStatements(DBPedia.createResource("Category:States_of_the_United_States"));
        query = DBPediaService.createQueryBuilder()
                .setLimit(4)
                .addWhereClause(RDF.type, DBPediaOWL.PopulatedPlace)
                .addPredicateExistsClause(FOAF.name)
                .addWhereClause(DCTerms.subject, statesOfUsa)
                .addFilterClause(RDFS.label, Locale.GERMAN)
                .addFilterClause(RDFS.label, Locale.ENGLISH);
        right = query.toQueryString();

        query.setLimit(2);
        query.removeWhereClause(DCTerms.subject, statesOfUsa);
        query.addMinusClause(DCTerms.subject, statesOfUsa);
        wrong = query.toQueryString();

        Question statesOfUsaQ;
        if((statesOfUsaQ = buildQuestion("Staaten der USA", "States of the USA", 50, right, wrong)) != null)
            category.addQuestion(statesOfUsaQ);

        JeopardyDAO.INSTANCE.persist(category);

        return category.getQuestions().size() > 0;
    }

    public static Question buildQuestion(String enText, String deText, int value, String right, String wrong) {

        Model rightModel = DBPediaService.loadStatements(right);
        List<String> englishRight = DBPediaService.getResourceNames(rightModel, Locale.ENGLISH);
        List<String> germanRight = DBPediaService.getResourceNames(rightModel, Locale.GERMAN);

        Model wrongModel = DBPediaService.loadStatements(wrong);
        List<String> englishWrong = DBPediaService.getResourceNames(wrongModel, Locale.ENGLISH);
        List<String> germanWrong = DBPediaService.getResourceNames(wrongModel, Locale.GERMAN);

        if(englishRight.size() != germanRight.size() || englishWrong.size() != germanWrong.size())
            return null;

        Question question = new Question();
        question.setTextEN(enText);
        question.setTextDE(deText);
        question.setValue(value);

        for(int i = 0; i < englishRight.size(); i++) {
            Answer answer = new Answer();
            answer.setCorrectAnswer(true);
            answer.setTextEN(englishRight.get(i));
            answer.setTextDE(germanRight.get(i));
            if(answer.getTextDE() != null && answer.getTextEN() != null
                    && !answer.getTextDE().equals("") && !answer.getTextEN().equals("")) {
                question.addRightAnswer(answer);
            }
        }

        for(int i = 0; i < englishWrong.size(); i++) {
            Answer answer = new Answer();
            answer.setCorrectAnswer(false);
            answer.setTextEN(englishWrong.get(i));
            answer.setTextDE(germanWrong.get(i));
            if(answer.getTextDE() != null && answer.getTextEN() != null
                    && !answer.getTextDE().equals("") && !answer.getTextEN().equals("")) {
                question.addWrongAnswer(answer);
            }
        }

        return question;
    }

}
