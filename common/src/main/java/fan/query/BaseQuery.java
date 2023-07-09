package fan.query;

/**
 * 基础查询参数
 *
 * @author Fan
 * @since 2023/6/9 14:41
 */
public class BaseQuery {

    private int currentPage;

    private int pageSize;

    public int getCurrentPage() {
        if (currentPage <= 0) {
            currentPage = 1;
        }
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        if (pageSize <= 0) {
            pageSize = 10;
        }
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
