package com.riosmind.churchscale.domain.service;

import com.riosmind.churchscale.domain.model.Scale;
import com.riosmind.churchscale.domain.model.Sector;
import com.riosmind.churchscale.domain.model.Volunteer;

import java.util.List;
import java.util.Map;

public class NotificationService {

    public void notifyScale(Scale scale) {
        System.out.println("=== Scale: " + scale.getName() + " — " + scale.getDate() + " ===");

        for (Map.Entry<Sector, List<Volunteer>> entry : scale.getAllocations().entrySet()) {
            String sectorName = entry.getKey().getName();
            List<Volunteer> volunteers = entry.getValue();

            System.out.println("\nSector: " + sectorName);

            for (Volunteer volunteer : volunteers) {
                System.out.println("  - " + volunteer.getName() + " (" + volunteer.getEmail() + ")");
            }
        }
    }

    public void notifyVolunteer(Volunteer volunteer, Scale scale) {
        System.out.println("Notification sent to: " + volunteer.getEmail());
        System.out.println("You are scheduled for: " + scale.getName() + " on " + scale.getDate());
    }
}