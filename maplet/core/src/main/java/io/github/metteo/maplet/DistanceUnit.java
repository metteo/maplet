package io.github.metteo.maplet;

public enum DistanceUnit {
    DEGREES("degrees"), FEET("ft"), METERS("m"), PIXELS("pixels"), USFEET("us-ft");

    private String mUnit;

    private DistanceUnit(String unit) {
	mUnit = unit;
    }
    
    public String getUnit() {
	return mUnit;
    }
}
