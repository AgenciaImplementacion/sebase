package ch.softenvironment.util;
/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 */
import ch.softenvironment.client.ResourceManager;
/**
 * Show Developer failures.
 * @author Peter Hirzel <i>soft</i>Environment
 * @version $Revision: 1.10 $ $Date: 2006-06-29 22:22:27 $
 */
public class DeveloperException extends RuntimeException {
	private String title = null;
	private String origin = null;
/**
 * @see #DeveloperException(String, String, Throwable)
 */
public DeveloperException(String message) {
    this(message, null, null, 1);
}
/**
 * @see #DeveloperException(String, String, Throwable)
 */
public DeveloperException(String message, String title) {
    this(message, title, null, 1);
}
/**
 * Construct a DeveloperException.
 * @param type Class where error happened
 * @param method producing the error
 * @param title Title for ErrorDialog
 * @param message Message for ErrorDialog
 * @param cause Original Exception happened
 */
public DeveloperException(String message, String title, Throwable cause) {
    this(message, title, cause, 1);
}

protected DeveloperException(String message, String title, Throwable cause, int stackTraceOffset) {
    super(message, cause);
    
    String msg = "";
    if (cause != null) {
        msg = "[" + ResourceManager.getResource(DeveloperException.class, "CIOriginalException") + ": " + cause.getMessage() + "]";
    }

    origin = Tracer.formatOrigin(Tracer.getOrigin(0 + 1 /*1=this constructor*/));
    Tracer.getInstance().developerError("[origin: " + origin + "] " + message + " " + msg);

    if (title == null) {
        this.title = ResourceManager.getResource(DeveloperException.class, "CTDevelopmentError");
    } else {
        this.title = title;
    }
}
/**
 * @deprecated
 */
public DeveloperException(Object object, String method, String message /*,String title, Throwable cause*/) {
    super(message); //super(message, cause);
    
/*  String msg = "";
    if (cause != null) {
        msg = "[" + ResourceManager.getResource(DeveloperException.class, "CIOriginalException") + ": " + cause.getMessage() + "]";
    }
*/    
    Class type = (object == null ? null : object.getClass());
    Tracer.getInstance().developerError(message + " " /*+ msg*/ + "in <" + type + "#" + method + ">");
    
    if (type != null) {
       origin = type.getName();
    } else {
       origin = "<???>";
    }
    origin = origin + "#" + method;
//  if (title == null) {
        this.title = ResourceManager.getResource(DeveloperException.class, "CTDevelopmentError");
/*  } else {
        this.title = title;
    }
*/
}
/**
 * Return the original title of error,
 * for e.g. to use in ErrorDialog as Title.
 */
public final String getTitle() {
	return title;
}
/**
 * Overwrites.
 * Print also source of failure and causing Exception if available.
 */
public final String getLocalizedMessage() {
    StringBuffer buffer = new StringBuffer();
    buffer.append(getMessage());
    // source of failure
    buffer.append("\n" + ResourceManager.getResource(DeveloperException.class, "CISource") + ": " + origin);
    if (getCause() != null) {
        // initiating Exception
        buffer.append("\n" + ResourceManager.getResource(DeveloperException.class, "CIOriginalException") + "=[" + getCause().getLocalizedMessage() + "]");
    }
    return buffer.toString();
}
}