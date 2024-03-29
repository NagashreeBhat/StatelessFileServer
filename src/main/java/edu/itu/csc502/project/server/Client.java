package edu.itu.csc502.project.server;

import edu.itu.csc502.project.remote.ClientCallback;

/**
 * This class represents a Client as viewed by the server.
 *
 * @author David Fisher
 */
public class Client {
    private final String name;
    private final ClientCallback callback;
    private boolean isActive;

    /**
     * Instantiates a new Client object with the given name.
     *
     * @param name
     *            The name of the client.
     * @param callback
     *            The callback for this client. Used to reach the client from the server.
     */
    public Client(final String name, final ClientCallback callback) {
        this.name = name;
        this.callback = callback;
        this.isActive = true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(final Object obj) {
        if ((obj == null) || !(obj instanceof Client)) {
            return false;
        } else {
            final Client castObj = (Client) obj;
            /**
             * Note: If more defining attributes are added to client, make sure to include them in this equals method.
             */
            return this.stringsAreEqual(this.name, castObj.name);
        }
    }

    /**
     * Sends this client a cache invalidation event for the given file name. <br/>
     * Note: this method most likely needs to be synchronized, but we may be able to unsynchronize it once we know the
     * implementation details.
     *
     * @param fileName
     *            The name of the file which is being invalidated.
     */
    public synchronized void sendCacheInvalidationEvent(final String fileName) {
        try {
            this.callback.invalidateCache(fileName);
        } catch (final Exception e) {
            /**
             * Note: Exceptions need to be handled within this method itself, as we don't want one client failure to
             * impact the notification of other clients.
             */
            e.printStackTrace();
        }
    }

    /**
     * Compares two String objects for equivalency.
     *
     * @param str1
     *            Base String.
     * @param str2
     *            Comparison String.
     * @return True if the two String objects are equivalent, or false otherwise.
     */
    private boolean stringsAreEqual(final String str1, final String str2) {
        return ((str1 != null) && str1.equals(str2)) || ((str1 == null) && (str2 == null));
    }

    /**
     * Returns the callback associated with this client.
     *
     * @return The callback associated with this client.
     */
    public ClientCallback getCallback() {
        return this.callback;
    }

    /**
     * Determines if this client is active or not.
     * 
     * @return Returns true if this client is active, or false if it has been deactivated.
     */
    public boolean isActive() {
        return this.isActive;
    }

    /**
     * Marks this Client as inactive.
     */
    public void deactivateClient() {
        this.isActive = false;
    }
}