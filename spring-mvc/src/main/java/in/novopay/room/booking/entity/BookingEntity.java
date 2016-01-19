package in.novopay.room.booking.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "booking")
public class BookingEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(mappedBy = "booking")
	private BookingRepeat bookingRepeatInfo;
	
	@ManyToOne
	@JoinColumn(name = "room_id")
	private RoomEntity room;

	@ManyToOne
	@JoinColumn(name = "from")
	private TimeSlotEntity from;
	
	@ManyToOne
	@JoinColumn(name = "to")
	private TimeSlotEntity to;
	
	@Column(name = "booking_date")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "M-")
	private Date date;
	
	@JoinColumn(name="user_id")
	@ManyToOne
	private UserEntity user;
	
	@ManyToMany
	@JoinTable(
		      name="booking_participants",
		      joinColumns={@JoinColumn(name="booking_id", referencedColumnName="id")},
		      inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="id")}
		      )
	private Set<UserEntity> participants = new HashSet<UserEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public RoomEntity getRoom() {
		return room;
	}

	public void setRoom(RoomEntity room) {
		this.room = room;
	}

	public TimeSlotEntity getFrom() {
		return from;
	}

	public void setFrom(TimeSlotEntity from) {
		this.from = from;
	}

	public TimeSlotEntity getTo() {
		return to;
	}

	public void setTo(TimeSlotEntity to) {
		this.to = to;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}
	
	public BookingRepeat getBookingRepeatInfo() {
		return bookingRepeatInfo;
	}

	public void setBookingRepeatInfo(BookingRepeat bookingRepeatInfo) {
		this.bookingRepeatInfo = bookingRepeatInfo;
	}
	
	public UserEntity addParticipant(UserEntity user) {
		if(user==null)
			return null;
		
		getParticipants().add(user);
		user.addBooking(this);
		
		return user;
	}
	
	public Set<UserEntity> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<UserEntity> participants) {
		this.participants = participants;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		BookingEntity other = (BookingEntity) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
