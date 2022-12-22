package me.sculk_sensor.doomsday.api.mechanism;


public enum CoordinateSystemType {
	NUMBER_AXIS(NumberAxisCoordinate.class),
	PLANE_RECTANGULAR_COORDINATE_SYSTEM(PlaneRectangularCoordinate.class),
	POLAR_COORDINATE_SYSTEM(PolarCoordinate.class),
	SPACE_RECTANGULAR_COORDINATE_SYSTEM(SpaceRectangularCoordinate.class),
	CYLINDRICAL_COORDINATE_SYSTEM(CylindricalCoordinate.class),
	SPHERICAL_COORDINATE_SYSTEM(SphericalCoordinate.class);

	public final Class<?> coordinateType;

	CoordinateSystemType(Class<?> type) {
		coordinateType = type;
	}

	CoordinateSystemType() {
		coordinateType = Void.TYPE;
	}
	
	public static class NumberAxisCoordinate {
		double z;
		public NumberAxisCoordinate(double z) {
			this.z = z;
		}
	}

	public static class PlaneRectangularCoordinate {
		double y, z;
		public PlaneRectangularCoordinate(double y, double z) {
			this.y = y;
			this.z = z;
		}
	}

	public static class PolarCoordinate {
		double r, theta;
		public PolarCoordinate(double r, double theta) {
			this.r = r;
			this.theta = theta;
		}
	}

	public static class SpaceRectangularCoordinate {
		double x, y, z;
		public SpaceRectangularCoordinate(double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	public static class CylindricalCoordinate {
		double r, theta, z;
		public CylindricalCoordinate(double r, double theta, double z) {
			this.r = r;
			this.theta = theta;
			this.z = z;
		}
	}

	public static class SphericalCoordinate {
		double r, theta, phi;
		public SphericalCoordinate(double r, double theta, double phi) {
			this.r = r;
			this.theta = theta;
			this.phi = phi;
		}
	}
}
