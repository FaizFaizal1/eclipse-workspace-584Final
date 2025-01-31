package courier.model;

import java.io.Serializable;

public class Route implements Serializable {
	private static final long serialVersionUId = 1L;
	private int routeId;
	private String routeSource;
	private String routeDestination;
	private double routeEstimatedDistance;

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getRouteSource() {
		return routeSource;
	}

	public void setRouteSource(String routeSource) {
		this.routeSource = routeSource;
	}

	public String getRouteDestination() {
		return routeDestination;
	}

	public void setRouteDestination(String routeDestination) {
		this.routeDestination = routeDestination;
	}

	public double getRouteEstimatedDistance() {
		return routeEstimatedDistance;
	}

	public void setRouteEstimatedDistance(double routeEstimatedDistance) {
		this.routeEstimatedDistance = routeEstimatedDistance;
	}

	public static long getSerialversionuid() {
		return serialVersionUId;
	}

}
