package parser.sql;

public class ParserLauncher {

    public static void main(String[] args) {
        SQLParser parser = new SQLParser();
        String simpleQuery = "SELECT * FROM book";
        String hardQuery = "SELECT author.name, count(book.id), sum(book.cost) \n" + 
                "FROM author\n" + 
                "LEFT JOIN book ON (author.id = book.author_id)\n" +
                "GROUP BY author.name\n" +
                "HAVING COUNT(*) > 1 AND SUM(book.cost) > 500\n" + 
                "LIMIT 10;";
        String hardLowSimbolsQuery = "select author.name, count(book.id), sum(book.cost) \n" + 
                "from author\n" + 
                "left join book on (author.id = book.author_id)\n" +
                "group by author.name\n" +
                "having count(*) > 1 and sum(book.cost) > 500\n" + 
                "limit 10;";
        parser.parseQuery(hardLowSimbolsQuery);
    }
}
