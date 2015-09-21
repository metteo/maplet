package io.github.metteo.maplet;

import javax.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Envelope;

@AutoValue
public abstract class CenterConstraint implements Constraint<Coordinate> {

    public static CenterConstraint newCenterConstraint() {
	return new AutoValue_CenterConstraint(null);
    }
    
    public static CenterConstraint newCenterConstraint(Envelope e) {
	return new AutoValue_CenterConstraint(e);
    }
    
    @Nullable
    abstract Envelope getEnvelope();
    
    //disabled panning, center in predefined point
    //none
    //constrain by envelope
    //constrain to a grid (every n meters) with snapping
    
    public Coordinate constrain(Coordinate coordinate) {
	//TODO: constrain the input and return it
	return coordinate;
    }
}
