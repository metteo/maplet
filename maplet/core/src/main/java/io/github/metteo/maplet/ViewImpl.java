package io.github.metteo.maplet;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.HashSet;
import java.util.Set;

import com.vividsolutions.jts.geom.Coordinate;

public class ViewImpl implements View {

    private static final long serialVersionUID = 7836464958297469414L;

    private final PropertyChangeSupport mPcs = new PropertyChangeSupport(this);
    private final VetoableChangeSupport mVcs = new VetoableChangeSupport(this);

    protected Coordinate mCenter;
    
    protected CenterConstraint mCenterConstraint;

    protected Crs mCrs;

    protected Double mResolution;
    
    protected ResolutionConstraint mResolutionConstraint;

    protected Double mRotation;
    
    protected RotationConstraint mRotationConstraint;

    protected Double mTilt;
    
    protected TiltConstraint mTiltConstraint;
    
    protected Set<Hint> mHints = new HashSet<>(2);
    
    protected transient int mModCount = 0;

    /*
     * For serialization
     */
    public ViewImpl() {
    }
    
    /**
     * Copy constructor
     * @param other
     */
    public ViewImpl(ViewImpl other) {
	mCenter = other.mCenter.copy();
	mCrs = other.mCrs.copy();
	mResolution = other.mResolution;
	mRotation = other.mRotation;
	mTilt = other.mTilt;
    }

    @Override
    public void setCenter(Coordinate center) throws PropertyVetoException {
	Coordinate oldValue = mCenter;

	fireVetoableChange(Property.CENTER, oldValue, center);

	mCenter = center;
	mModCount++;

	firePropertyChange(Property.CENTER, oldValue, center);
    }

    @Override
    public Coordinate getCenter() {
	return mCenter;
    }

    @Override
    public void setCrs(Crs crs) {
	mCrs = crs;
	mModCount++;
    }

    @Override
    public Crs getCrs() {
	return mCrs;
    }

    @Override
    public void setResolution(Double resolution) throws PropertyVetoException {
	Double oldValue = mResolution;

	fireVetoableChange(Property.RESOLUTION, oldValue, resolution);

	mResolution = resolution;
	mModCount++;

	firePropertyChange(Property.RESOLUTION, oldValue, resolution);
    }

    @Override
    public Double getResolution() {
	return mResolution;
    }

    @Override
    public void setRotation(Double rotation) throws PropertyVetoException {
	Double oldValue = mRotation;

	fireVetoableChange(Property.ROTATION, oldValue, rotation);

	mRotation = rotation;
	mModCount++;

	firePropertyChange(Property.ROTATION, oldValue, rotation);
    }

    @Override
    public Double getRotation() {
	return mRotation;
    }

    @Override
    public void setTilt(Double tilt) throws PropertyVetoException {
	Double oldValue = mTilt;

	fireVetoableChange(Property.TILT, oldValue, tilt);

	mTilt = tilt;
	mModCount++;

	firePropertyChange(Property.TILT, oldValue, tilt);
    }

    @Override
    public Double getTilt() {
	return mTilt;
    }

    private void fireVetoableChange(Property property, Object oldValue, Object newValue) throws PropertyVetoException {
	mVcs.fireVetoableChange(property.asProperty(), oldValue, newValue);
    }

    private void firePropertyChange(Property property, Object oldValue, Object newValue) {
	mPcs.firePropertyChange(property.asProperty(), oldValue, newValue);
    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
	mPcs.addPropertyChangeListener(listener);
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener listener) {
	mPcs.removePropertyChangeListener(listener);
    }

    @Override
    public void addVetoableChangeListener(VetoableChangeListener listener) {
	mVcs.addVetoableChangeListener(listener);
    }

    @Override
    public void removeVetoableChangeListener(VetoableChangeListener listener) {
	mVcs.removeVetoableChangeListener(listener);
    }
    
    @Override
    public View copy() {
	return new ViewImpl(this);
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((mCenter == null) ? 0 : mCenter.hashCode());
	result = prime * result + ((mCrs == null) ? 0 : mCrs.hashCode());
	result = prime * result + ((mResolution == null) ? 0 : mResolution.hashCode());
	result = prime * result + ((mRotation == null) ? 0 : mRotation.hashCode());
	result = prime * result + ((mTilt == null) ? 0 : mTilt.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	ViewImpl other = (ViewImpl) obj;
	if (mCenter == null) {
	    if (other.mCenter != null)
		return false;
	} else if (!mCenter.equals(other.mCenter))
	    return false;
	if (mCrs == null) {
	    if (other.mCrs != null)
		return false;
	} else if (!mCrs.equals(other.mCrs))
	    return false;
	if (mResolution == null) {
	    if (other.mResolution != null)
		return false;
	} else if (!mResolution.equals(other.mResolution))
	    return false;
	if (mRotation == null) {
	    if (other.mRotation != null)
		return false;
	} else if (!mRotation.equals(other.mRotation))
	    return false;
	if (mTilt == null) {
	    if (other.mTilt != null)
		return false;
	} else if (!mTilt.equals(other.mTilt))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "View [center=" + mCenter + ", projection=" + mCrs + ", resolution=" + mResolution + ", rotation="
		+ mRotation + ", tilt=" + mTilt + "]";
    }

}
