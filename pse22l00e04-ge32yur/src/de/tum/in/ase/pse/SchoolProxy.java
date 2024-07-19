package de.tum.in.ase.pse;

import java.net.URL;
import java.util.Set;

public class SchoolProxy implements ConnectionInterface {
    private Set<String> denylistedHosts;
    private URL redirectPage;
    private Set<Integer> teacherIDs;
    private boolean authorized;
    private NetworkConnection networkConnection;

    public SchoolProxy(Set<String> denylistedHosts, URL redirectPage, Set<Integer> teacherIDs) {
        this.networkConnection = new NetworkConnection();
        authorized = false;
        this.denylistedHosts = denylistedHosts;
        this.redirectPage = redirectPage;
        this.teacherIDs = teacherIDs;
    }

    @Override
    public void connect(URL url) {
        if (authorized || !denylistedHosts.contains(url.getHost())) {
            networkConnection.connect(url);
        }
        else {
            System.err.println("Connection to '" + url + "' was rejected!");
            networkConnection.connect(redirectPage);
        }
    }

    @Override
    public void disconnect() {
        networkConnection.disconnect();
    }

    @Override
    public boolean isConnected() {
        return networkConnection.isConnected();
    }
    public void login(int teacherID) {
        if (teacherIDs.contains(teacherID)) {
            authorized = true;
        }
    }

    public void logout() {
        authorized = false;
    }
    // TODO: Implement the SchoolProxy

}
