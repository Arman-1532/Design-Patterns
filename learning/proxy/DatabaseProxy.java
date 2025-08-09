package learning.proxy;

class DatabaseProxy implements Database {
    private String userRole;
    private RealDatabase realDatabase = new RealDatabase();

    public DatabaseProxy(String userRole) {
        this.userRole = userRole;
    }

    @Override
    public void query(String sql) {
        if ("admin".equalsIgnoreCase(userRole)) {
            System.out.print("[Admin] ");
            realDatabase.query(sql);
        } else {
            System.out.println("[Guest] Access denied for query: " + sql);
        }
    }
}