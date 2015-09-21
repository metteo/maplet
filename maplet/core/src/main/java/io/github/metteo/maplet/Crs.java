package io.github.metteo.maplet;

import java.io.Serializable;

import javax.annotation.Nullable;

import com.google.auto.value.AutoValue;
import com.vividsolutions.jts.geom.Envelope;

@AutoValue
public abstract class Crs implements Serializable {

    private static final long serialVersionUID = -7488066220886402635L;

    public static Crs newCrs(String code, DistanceUnit unit, Envelope envelope, String axisOrient, boolean global) {
	return new AutoValue_Crs(code, unit, envelope, axisOrient, global);
    }

    public abstract String getCode();

    public abstract DistanceUnit getUnit();

    @Nullable
    public abstract Envelope getEnvelope();

    @Nullable
    public abstract String getAxisOrientation();

    @Nullable
    public abstract Boolean isGlobal();

    public Crs copy() {
	return newCrs(getCode(), getUnit(), getEnvelope().copy(), getAxisOrientation(), isGlobal());
    }

}
