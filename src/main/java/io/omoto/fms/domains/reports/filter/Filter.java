package io.omoto.fms.domains.reports.filter;


import java.util.List;

public class Filter {
    private List<FiltersEntity> filters;
    private String type;
    private long userId;
    private long accountId;
    private Integer pageNo;
    private Integer pageSize;

    public List<FiltersEntity> getFilters() {
        return filters;
    }

    public void setFilters(List<FiltersEntity> filters) {
        this.filters = filters;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public static class FiltersEntity {
        private String name;
        private String value;

        public void setName(String name) {
            this.name = name;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public String getValue() {
            return value;
        }
    }
}
