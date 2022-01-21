package hotel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Room {

	private Integer roomNumber;
	private List<BookingDetail> bookings;

	public Room(Integer roomNumber) {
		this.roomNumber = roomNumber;
		bookings = new ArrayList<BookingDetail>();
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public List<BookingDetail> getBookings() {
		return bookings;
	}

	public void setBookings(List<BookingDetail> bookings) {
		this.bookings = bookings;
	}

	public void addBooking(BookingDetail booking) { bookings.add(booking); }

	public Boolean isAvailable(LocalDate date){
		for(int i = 0; i < bookings.size(); i++){
			if(bookings.get(i).getDate().equals(date)){
				return false;
			}
		}
		return true;
	}
}