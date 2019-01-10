package com.example.golnazelmamooz.hellobeacon2018;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class ServiceImpl extends IntentService {

    private long seconds;
    //TODO: include needed fields

    public ServiceImpl() {
        super("ServiceImpl");
    }

    protected void onHandleIntent(Intent intent) {

        //TODO: uncomment this, when implemented setupInputReader();

        //TODO: get the seconds from intent

        //how long the service should sleep, in milliseconds
        long millis = seconds * 1000;
        while (true) {
            try {
                Beacon beacon = scanBeacon();

                if(beacon != null){
                    //TODO: add beacons to the List of scanned beacons

                    //TODO: notification

                    //TODO: intent to AddBeaconsActivity

                    //build intent to switch to activity on click
                    TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);

                    //adds the back stack for the Intent (not the intent itself)
                    stackBuilder.addParentStack(AddBeaconsActivity.class);

                    //adds the intent that starts and puts the activity to the top of the stack
                    //TODO: uncomment this and insert the above created intent as input
                    //stackBuilder.addNextIntent();

                    //PendingIntent waits for an event
                    PendingIntent scanResultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

                    notificationBuilder.setContentIntent(scanResultPendingIntent);
                    Notification notification = notificationBuilder.build();
                    NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                    notificationManager.notify(1, notification);
                }

                //TODO: put the service to sleep

            } catch (InterruptedException iEx) {
                Log.d("Message", iEx.getMessage());
            }
        }
    }

    private void setupInputReader() {

        //TODO: read the file "Beacon.txt"
        //read the header in advance to exclude it from the output


    }

    private Beacon scanBeacon() {
        //TODO: Read a line and split one row into the beacon components uuid, major and minor
        //create a new beacon and return it

    }



    public void onDestroy() {
        //TODO: implement this
    }
}