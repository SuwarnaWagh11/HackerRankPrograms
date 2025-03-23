package somethingnew;

import java.util.Comparator;

public class LocationCompare implements Comparator<ClassLocationDto> {


    @Override
    public int compare(ClassLocationDto o1, ClassLocationDto o2) {
        final var result = compareBookingType(o1.getBookingType(), o2.getBookingType());
        if(result != 0){
            return result;
        }
        return compareDistance(o1.getDistance(), o2.getDistance());
    }

    private int compareDistance(Double distance, Double distance1) {
        if(distance != null && distance1 != null){
            return Double.compare(distance,distance1);
        }
         return Boolean.compare(distance == null, distance1 == null);
    }

    private int compareBookingType(BookingType bookingType, BookingType bookingType1) {
        return Boolean.compare(bookingType == BookingType.INSTANT, bookingType1 == BookingType.INSTANT);
    }
}
