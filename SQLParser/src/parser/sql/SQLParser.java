package parser.sql;

public class SQLParser {

    public Query parseQuery(String inputQuery) {
        Query result = new Query();
        parseColoumns(inputQuery, result);
        System.out.println();
        return null;
    }

    private Query parseColoumns(String inputQuery, Query query) {
        String[] splitedInput = inputQuery.split("FROM");
        if (splitedInput.length == 1) {
            splitedInput = inputQuery.split("from");
        }
        String[] inputColoumns = splitedInput[0].trim().split(" ");
        for (int i = 1; i < inputColoumns.length; i++) {
            String coloumn = inputColoumns[i];
            if (coloumn.endsWith(",")) {
                coloumn = coloumn.substring(0, coloumn.lastIndexOf(","));
            }
            query.addColoumn(coloumn.trim());
        }
        parseOtherParts(splitedInput[1].trim(), query);
        return query;
    }

    private Query parseOtherParts(String inputQuery, Query query) {
        if (inputQuery.contains("JOIN") || inputQuery.contains("join")) {
            parseJoins(inputQuery, query);
        } else if (inputQuery.contains("ORDER BY") || inputQuery.contains("order by")) {
            parseOrderByCondition(inputQuery, query);
        } else if (inputQuery.contains("GROUP BY") || inputQuery.contains("group by")) {
            parseGroupByCondition(inputQuery, query);
        } else if (inputQuery.contains("LIMIT") || inputQuery.contains("limit")) {
            parseLimitCondition(inputQuery, query);
        } else if (query.getSources() == null) {
            parseSources(inputQuery, query);
        }
        return query;
    }

    private Query parseSources(String inputQuery, Query query) {
        String[] splitedInput = inputQuery.split(",");
        for (String sourse : splitedInput) {
            query.addSource(sourse.trim());
        }
        return query;
    }

    private Query parseJoins(String inputQuery, Query query) {
        String[] splitedInput = new String[0];
        if (inputQuery.contains("INNER") || inputQuery.contains("inner")) {
            splitedInput = inputQuery.split("INNER JOIN");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("inner join");
            }
        }
        if (inputQuery.contains("LEFT") || inputQuery.contains("left")) {
            splitedInput = inputQuery.split("LEFT JOIN");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("left join");
                if (splitedInput.length == 1) {
                    splitedInput = inputQuery.split("LEFT OUTER JOIN");
                    if (splitedInput.length == 1) {
                        splitedInput = inputQuery.split("left outer join");
                    }
                }
            }

        }
        if (inputQuery.contains("RIGHT") || inputQuery.contains("right")) {
            splitedInput = inputQuery.split("RIGHT JOIN");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("right join");
                if (splitedInput.length == 1) {
                    splitedInput = inputQuery.split("RIGHT OUTER JOIN");
                    if (splitedInput.length == 1) {
                        splitedInput = inputQuery.split("right outer join");
                    }
                }
            }

        }
        if (inputQuery.contains("FULL") || inputQuery.contains("full")) {
            splitedInput = inputQuery.split("FULL JOIN");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("full join");
                if (splitedInput.length == 1) {
                    splitedInput = inputQuery.split("FULL OUTER JOIN");
                    if (splitedInput.length == 1) {
                        splitedInput = inputQuery.split("full outer join");
                    }
                }
            }

        }
        String[] inputJoins = splitedInput[1].split("ON");
        parseOtherParts(splitedInput[0].trim(), query);
        parseOtherParts(splitedInput[1].trim(), query);
        Join join = new Join();
        join.setTableName(inputJoins[0].trim());
        join.setCondition(parseCondition(inputJoins[1].trim()));
        query.addJoin(join);
        return query;
    }

    private Query parseGroupByCondition(String inputQuery, Query query) {
        String[] splitedInput = inputQuery.split("GROUP BY");
        if (splitedInput.length == 1) {
            splitedInput = inputQuery.split("group by");
        }
        String condition = parseCondition(splitedInput[1]);
        query.addGroupByColumn(condition);
        parseOtherParts(splitedInput[1], query);
        return query;
    }

    private Query parseOrderByCondition(String inputQuery, Query query) {
        String[] splitedInput = inputQuery.split("ORDER BY");
        if (splitedInput.length == 1) {
            splitedInput = inputQuery.split("order by");
        }
        String condition = parseCondition(splitedInput[1]);
        query.addSortColumn(condition);
        parseOtherParts(splitedInput[1], query);
        return query;
    }

    private Query parseLimitCondition(String inputQuery, Query query) {
        String[] splitedInput = inputQuery.split("LIMIT");
        if (splitedInput.length == 1) {
            splitedInput = inputQuery.split("limit");
        }
        int limit = Integer.parseInt(parseCondition(splitedInput[1]));
        query.setLimit(limit);
        parseOtherParts(splitedInput[1], query);
        return query;
    }

    private String parseCondition(String inputQuery) {
        if (inputQuery.contains("GROUP BY") || inputQuery.contains("group by")) {
            String[] splitedInput = inputQuery.split("GROUP BY");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("group by");
            }
            if (splitedInput[0].trim().endsWith(";")) {
                String condition = inputQuery.trim();
                condition = condition.substring(0, condition.length() - 1);
                return condition;
            }
            return splitedInput[0].trim();
        }
        if (inputQuery.contains("ORDER BY") || inputQuery.contains("order by")) {
            String[] splitedInput = inputQuery.split("ORDER BY");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("order by");
            }
            if (splitedInput[0].trim().endsWith(";")) {
                String condition = inputQuery.trim();
                condition = condition.substring(0, condition.length() - 1);
                return condition;
            }
            return splitedInput[0].trim();
        }
        if (inputQuery.contains("WHERE") || inputQuery.contains("where")) {
            String[] splitedInput = inputQuery.split("WHERE");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("where");
            }
            if (splitedInput[0].trim().endsWith(";")) {
                String condition = inputQuery.trim();
                condition = condition.substring(0, condition.length() - 1);
                return condition;
            }
            return splitedInput[0].trim();
        }
        if (inputQuery.contains("HAVING") || inputQuery.contains("having")) {
            String[] splitedInput = inputQuery.split("HAVING");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("having");
            }
            if (splitedInput[0].trim().endsWith(";")) {
                String condition = inputQuery.trim();
                condition = condition.substring(0, condition.length() - 1);
                return condition;
            }
            return splitedInput[0].trim();
        }
        if (inputQuery.contains("LIMIT") || inputQuery.contains("limit")) {
            String[] splitedInput = inputQuery.split("LIMIT");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("limit");
            }
            if (splitedInput[0].trim().endsWith(";")) {
                String condition = inputQuery.trim();
                condition = condition.substring(0, condition.length() - 1);
                return condition;
            }
            return splitedInput[0].trim();
        }
        if (inputQuery.contains("OFFSET") || inputQuery.contains("offset")) {
            String[] splitedInput = inputQuery.split("OFFSET");
            if (splitedInput.length == 1) {
                splitedInput = inputQuery.split("offset");
            }
            if (splitedInput[0].trim().endsWith(";")) {
                String condition = inputQuery.trim();
                condition = condition.substring(0, condition.length() - 1);
                return condition;
            }
            return splitedInput[0].trim();
        }
        if (inputQuery.endsWith(";")) {
            String condition = inputQuery.trim();
            condition = condition.substring(0, condition.length() - 1);
            return condition;
        }
        return inputQuery.trim();
    }
}
