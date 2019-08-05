package p06_TirePressureMonitoringSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class AlarmTest {

    private Alarm alarm;

    @Before
    public void build(){
        this.alarm = new Alarm();

    }


    @Test
    public void alarmShouldBeFlaseWhenPresureIsMoreThen17() throws NoSuchFieldException, IllegalAccessException {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(17d);

        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);

        fieldSensor.set(this.alarm,sensor);

        alarm.check();
        Assert.assertFalse(this.alarm.getAlarmOn());

    }
    @Test
    public void alarmShouldBeTrueWhenPresureIsUnder17() throws NoSuchFieldException, IllegalAccessException {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(16.99);

        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);

        fieldSensor.set(this.alarm,sensor);

        alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());

    }
    @Test
    public void alarmShouldBeTrueWhenPresureIsMoreThen21() throws NoSuchFieldException, IllegalAccessException {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21.01);

        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);

        fieldSensor.set(this.alarm,sensor);

        alarm.check();
        Assert.assertTrue(this.alarm.getAlarmOn());

    }
    @Test
    public void alarmShouldBeFlaseWhenPresureIsUnderOrEquals21() throws NoSuchFieldException, IllegalAccessException {

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue()).thenReturn(21d);

        Field fieldSensor = Alarm.class.getDeclaredField("sensor");
        fieldSensor.setAccessible(true);

        fieldSensor.set(this.alarm,sensor);

        alarm.check();
        Assert.assertFalse(this.alarm.getAlarmOn());

    }




}