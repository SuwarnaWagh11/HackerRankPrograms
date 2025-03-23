package somethingnew;

import org.testng.Assert;
import org.testng.annotations.Test;

public class NewTest101Test {
    ClassLocationDto classLocationDtoReq =new ClassLocationDto();
    ClassLocationDto classLocationDtoResp =new ClassLocationDto();
    LocationCompare locationCompare = new LocationCompare();

    @Test
    public void testWithSameBookingTypeWithMaxDistanceForResp(){
        classLocationDtoReq.setDistance(34.000);
        classLocationDtoReq.setBookingType(BookingType.INSTANT);
        classLocationDtoResp.setDistance(50.000);
        classLocationDtoResp.setBookingType(BookingType.INSTANT);

        int res = locationCompare.compare(classLocationDtoReq, classLocationDtoResp);
        System.out.println("testWithSameBookingTypeWithMaxDistanceForResp " + res);
        Assert.assertEquals(res, -1, "As both Booking Type is Instant(i.e returned 0) hence compared with distance & they Both are not same");
    }
    @Test
    public void testWithSameBookingTypeWithMaxDistanceForReq(){
        classLocationDtoReq.setDistance(340.000);
        classLocationDtoReq.setBookingType(BookingType.INSTANT);
        classLocationDtoResp.setDistance(50.000);
        classLocationDtoResp.setBookingType(BookingType.INSTANT);

        int res = locationCompare.compare(classLocationDtoReq, classLocationDtoResp);
        System.out.println("testWithSameBookingTypeOnly " + res);
        Assert.assertEquals(res, 1, "As both Booking Type is Instant(i.e returned 0) hence compared with distance & they Both are not same");
    }
    @Test
    public void testWithDiffBookingTypeOnly(){
        classLocationDtoReq.setDistance(51.000);
        classLocationDtoReq.setBookingType(BookingType.INSTANT);
        classLocationDtoResp.setDistance(50.000);
        classLocationDtoResp.setBookingType(BookingType.HYBRID);

        int res = locationCompare.compare(classLocationDtoReq, classLocationDtoResp);
        System.out.println("testWithDiffBookingTypeOnly " + res);
        Assert.assertEquals(res, 1, "As both Booking Type is NOT Instant hence returned 1, IT WILL NOT CHECK FOR DISTANCE");
    }
    @Test
    public void testWithSameDistanceOnly(){
        classLocationDtoReq.setDistance(50.000);
        classLocationDtoReq.setBookingType(BookingType.INSTANT);
        classLocationDtoResp.setDistance(50.000);
        classLocationDtoResp.setBookingType(BookingType.INSTANT);

        int res = locationCompare.compare(classLocationDtoReq, classLocationDtoResp);
        Assert.assertEquals(res, 0, "As both Booking Type is Instant and distance is same hence returned 0");
    }
    @Test
    public void testWithDiffBookingTypeAndDiffDistance(){
        classLocationDtoReq.setDistance(34.000);
        classLocationDtoReq.setBookingType(BookingType.REQUEST);
        classLocationDtoResp.setDistance(34.000);
        classLocationDtoResp.setBookingType(BookingType.NON_EXISTING_BOOKING_TYPE);

        int res = locationCompare.compare(classLocationDtoReq, classLocationDtoResp);
        System.out.println("testWithDiffBookingTypeOnly " + res);
        Assert.assertEquals(res, 0, "As both Booking Type is not Instant and distance is same hence returned 0");
    }
}
