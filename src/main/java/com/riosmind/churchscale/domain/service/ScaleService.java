package domain.service;

import domain.exception.SectorWithoutVolunteersException;
import domain.exception.VolunteerUnavailableException;
import domain.model.Scale;
import domain.model.Sector;
import domain.model.Volunteer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScaleService {

    public Scale createScale(String name, java.time.LocalDate date){
        Scale scale = new Scale(name, date, new HashMap<>());
        return scale;
    }

    public void allocateVolunteer(Scale scale, Sector sector, Volunteer volunteer){
        if (!volunteer.getAvailableDate().equals(scale.getDate())){
            throw new VolunteerUnavailableException(volunteer.getName(), scale.getDate());
        }

        Map<Sector, List<Volunteer>> allocations = scale.getAllocations();

        allocations.computeIfAbsent(sector, k -> new ArrayList<>()).add(volunteer);
    }

    public List<Volunteer> getVolunteersBySector(Scale scale, Sector sector) {
        List<Volunteer> volunteers = scale.getAllocations().get(sector);

        if (volunteers == null || volunteers.isEmpty()) {
            throw new SectorWithoutVolunteersException(sector.getName());
        }

        return volunteers;
    }
}
