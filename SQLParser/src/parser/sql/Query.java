package parser.sql;

import java.util.ArrayList;
import java.util.List;

public class Query {

    private List<String> coloumns;
    private List<String> sources;
    private List<Join> joins;
    private List<WhereClause> whereClauses;
    private List<String> groupByColumns;
    private List<String> sortColumns;
    private Integer limit;
    private Integer offset;

    public List<String> getColoumns() {
        return coloumns;
    }

    public void addColoumn(String coloumn) {
        if (coloumns == null) {
            coloumns = new ArrayList<>();
        }
        coloumns.add(coloumn);
    }

    public List<String> getSources() {
        return sources;
    }

    public void addSource(String source) {
        if (sources == null) {
            sources = new ArrayList<>();
        }
        sources.add(source);
    }

    public List<Join> getJoins() {
        return joins;
    }

    public void addJoin(Join join) {
        if (joins == null) {
            joins = new ArrayList<>();
        }
        joins.add(join);
    }

    public List<WhereClause> getWhereClauses() {
        return whereClauses;
    }

    public void setWhereClauses(List<WhereClause> whereClauses) {
        this.whereClauses = whereClauses;
    }

    public List<String> getGroupByColumns() {
        return groupByColumns;
    }

    public void addGroupByColumn(String groupByColumn) {
        if (groupByColumns == null) {
            groupByColumns = new ArrayList<>();
        }
        groupByColumns.add(groupByColumn);
    }

    public List<String> getSortColumns() {
        return sortColumns;
    }
    
    public void addSortColumn(String sortColumn) {
        if (sortColumns == null) {
            sortColumns = new ArrayList<>();
        }
        sortColumns.add(sortColumn);
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
