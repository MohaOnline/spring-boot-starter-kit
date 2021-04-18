package cn.com.tanan.boot.common;

/**
 * The status of record.
 */
public enum Status {
    ACTIVE, DELETED, PENDING;

    @Override
    public String toString() {
        switch (this){
            case ACTIVE:
                return "Active";
            case DELETED:
                return "Deleted";
            case PENDING:
                return "Pending";
        }

        return "";
    }
}
