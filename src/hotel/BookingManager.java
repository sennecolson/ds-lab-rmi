package hotel;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class BookingManager {

	private Room[] rooms;

	public BookingManager() {
		this.rooms = initializeRooms();
	}

	public Set<Integer> getAllRooms() {
		Set<Integer> allRooms = new HashSet<Integer>();
		Iterable<Room> roomIterator = Arrays.asList(rooms);
		for (Room room : roomIterator) {
			allRooms.add(room.getRoomNumber());
		}
		return allRooms;
	}

	/**
	 * Check if room is available
	 *
	 * @param roomNumber the number of the room
	 * @param date the date for which we need to check availability
	 * @return true if room exists and is available on the provided date
	 */
	public boolean isRoomAvailable(Integer roomNumber, LocalDate date) {
		Room room = getRoomFromNumber(roomNumber);
		if (room == null) return false;
		return room.isAvailable(date);
	}

	/**
	 * Add booking to a room
	 *
	 * @param bookingDetail the details of the booking
	 */
	public void addBooking(BookingDetail bookingDetail) {
		Room room = getRoomFromNumber(bookingDetail.getRoomNumber());
		room.addBooking(bookingDetail);
	}

	/**
	 * Get all rooms that are available on the specified date
	 *
	 * @param date the date for which the rooms should be available
	 * @return all rooms that are available on the specified date
	 */
	public Set<Integer> getAvailableRooms(LocalDate date) {
		Set<Integer> availableRooms = new HashSet<Integer>();
		for (int i = 0; i < rooms.length; i++) {
			if (rooms[i].isAvailable(date)){
				availableRooms.add(rooms[i].getRoomNumber());
			}
		}
		return availableRooms;
	}

	private static Room[] initializeRooms() {
		Room[] rooms = new Room[4];
		rooms[0] = new Room(101);
		rooms[1] = new Room(102);
		rooms[2] = new Room(201);
		rooms[3] = new Room(203);
		return rooms;
	}

	/**
	 * Helper function to get room from roomnumber
	 *
	 * @param number the roomnumber for which the room should be retrieved
	 * @return the room with the specified roomnumber
	 */
	private Room getRoomFromNumber(Integer number){
		for (int i = 0; i < rooms.length; i++) {
			if(rooms[i].getRoomNumber() == number) return rooms[i];
		}
		return null;
	}
}
