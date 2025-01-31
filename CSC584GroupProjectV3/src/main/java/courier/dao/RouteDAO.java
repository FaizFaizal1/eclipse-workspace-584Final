package courier.dao;

/**
 * Author: Fadilah Ezlina Shahbudin (fadilahezlina@uitm.edu.my)
 * Date: June 2024
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import courier.connection.ConnectionManager;
import courier.model.Route;

public class RouteDAO {
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement ps = null;
	private static String sql = null;

	// add route
	public static void addRoute(Route route) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "INSERT INTO route(route_source,route_destination,route_estimated_distance)VALUES(?,?,?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, route.getRouteSource());
			ps.setString(2, route.getRouteDestination());
			ps.setDouble(3, route.getRouteEstimatedDistance());

			// 4. execute query
			ps.executeUpdate();

			System.out.print("Route added successfully");

			// 5. close connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get all routes
	public static List<Route> getAllRoutes() {
		List<Route> routes = new ArrayList<Route>();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM route ORDER BY routeId";
			ps = con.prepareStatement(sql);

			// 4. execute query
			rs = ps.executeQuery();

			while (rs.next()) {
				Route route = new Route();
				route.setRouteID(rs.getInt("routeId"));
				route.setRouteSource(rs.getString("route_source"));
				route.setRouteDestination(rs.getString("route_destination"));
				route.setRouteEstimatedDistance(rs.getDouble("route_estimated_distance"));
				routes.add(route);
			}
			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return routes;
	}

	// get route by Id
	public static Route getRouteById(int routeId) {
		Route route = new Route();
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "SELECT * FROM route WHERE routeId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, routeId);

			// 4. execute query
			rs = ps.executeQuery();

			if (rs.next()) {
				route.setRouteID(rs.getInt("routeId"));
				route.setRouteSource(rs.getString("route_source"));
				route.setRouteDestination(rs.getString("route_destination"));
				route.setRouteEstimatedDistance(rs.getDouble("route_estimated_distance"));
			}

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return route;
	}

	// delete route
	public static void deleteRoute(int routeId) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "DELETE FROM route WHERE routeId = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, routeId);

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update route
	public static void updateRoute(Route route) {
		try {
			// call getConnection() method
			con = ConnectionManager.getConnection();

			// 3. create statement
			sql = "UPDATE route SET route_source=?, route_destination=?, route_estimated_distance=? WHERE routeId=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, route.getRouteSource());
			ps.setString(2, route.getRouteDestination());
			ps.setDouble(3, route.getRouteEstimatedDistance());

			// 4. execute query
			ps.executeUpdate();

			// 5. close connection
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}