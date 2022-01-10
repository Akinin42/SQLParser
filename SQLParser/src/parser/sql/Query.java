package parser.sql;

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

    public void setColoumns(List<String> coloumns) {
        this.coloumns = coloumns;
    }

    public List<String> getSources() {
        return sources;
    }

    public void setSources(List<String> sources) {
        this.sources = sources;
    }

    public List<Join> getJoins() {
        return joins;
    }

    public void setJoins(List<Join> joins) {
        this.joins = joins;
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

    public void setGroupByColumns(List<String> groupByColumns) {
        this.groupByColumns = groupByColumns;
    }

    public List<String> getSortColumns() {
        return sortColumns;
    }

    public void setSortColumns(List<String> sortColumns) {
        this.sortColumns = sortColumns;
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
