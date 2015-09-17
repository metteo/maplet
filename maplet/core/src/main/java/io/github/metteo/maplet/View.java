package io.github.metteo.maplet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.io.Serializable;

import com.vividsolutions.jts.geom.Coordinate;

public interface View extends Serializable {
    
    public enum Property {
	CENTER, RESOLUTION, ROTATION, TILT;

	public String asProperty() {
	    return toString().toLowerCase();
	}
    }

    public enum Hint {
	ANIMATING, INTERACTING
    }

    void setCenter(Coordinate center) throws PropertyVetoException;

    Coordinate getCenter();

    void setProjection(Projection projection);

    Projection getProjection();

    void setResolution(Double resolution) throws PropertyVetoException;

    Double getResolution();

    void setRotation(Double rotation) throws PropertyVetoException;

    Double getRotation();

    void setTilt(Double tilt) throws PropertyVetoException;

    Double getTilt();

    void addPropertyChangeListener(PropertyChangeListener listener);

    void removePropertyChangeListener(PropertyChangeListener listener);

    void addVetoableChangeListener(VetoableChangeListener listener);

    void removeVetoableChangeListener(VetoableChangeListener listener);

    /**
     * Replacement for {@link Object#clone()}
     * @return
     */
    View copy();
}
