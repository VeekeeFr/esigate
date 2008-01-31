package net.webassembletool.resource;

import java.io.IOException;

import net.webassembletool.ouput.Output;

/**
 * An HTML page or resource (image, stylesheet...) that can be rendered to an
 * HttpServletResponse.<br />
 * A resource can come directly from a proxied request but also from a cache or
 * a file.<br />
 * A resource must be released after using it in ordre to release open files or
 * network connections.
 * 
 * @author Fran�ois-Xavier Bonnet
 * 
 */
public interface Resource {
    /**
     * Renders the Resource to an Output
     * 
     * @param output
     *                The output to render the resource to.
     * @throws IOException
     */
    public void render(Output output) throws IOException;

    /**
     * Verifies if the Resource exists on the remote server or on the local
     * filesystem, depending on the implementation.
     * 
     * @return true if the resource exists
     */
    public boolean exists();

    /**
     * Releases underlying open files or network connections
     */
    public void release();
}
