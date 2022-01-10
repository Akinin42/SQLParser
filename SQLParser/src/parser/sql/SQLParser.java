package parser.sql;

import java.util.ArrayList;
import java.util.List;

public class SQLParser {

    public Query parseQuery(String inputQuery) {
        Query result = new Query();
        parseColoumns(inputQuery, result);
        System.out.println();
        return null;
    }

    private Query parseColoumns(String inputQuery, Query query) {
        String[] inputColoumns = inputQuery.split("FROM");
        if (inputColoumns.length == 1) {
            inputColoumns = inputQuery.split("from");
        }
        inputColoumns = inputColoumns[0].trim().split(" ");
        List<String> coloumns = new ArrayList<>();
        for (int i = 1; i < inputColoumns.length; i++) {
            String coloumn = inputColoumns[i];
            if(coloumn.endsWith(",")) {
                coloumn = coloumn.substring(0, coloumn.lastIndexOf(","));
            }
            coloumns.add(coloumn.trim());
        }
        query.setColoumns(coloumns);
        return query;
    }
}
