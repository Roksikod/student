package org.example.student.service;

import org.example.student.entity.model.FrontTutor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FrontTutorService {
    private List<FrontTutor> frontTutors = new ArrayList<>();
    private int ID = 0;

    {
        frontTutors.add(new FrontTutor(++ID, "Николай", "С", "Разработчик с 2021 года, любит рыбалку", 36, "Москва", "@Nickol", "nickolay@gmail.com"));
        frontTutors.add(new FrontTutor(++ID, "Сергей", "Б", "Математик, работает с безопасностью сетей, учится на программиста С++", 36, "Новосибирск", "@Serg", "sergey@gmail.com"));
        frontTutors.add(new FrontTutor(++ID, "Александр", "М", "Разработчик с 2022 года, любит шахматы", 32, "Москва", "@Aleks", "aleksandr@gmail.com"));
        frontTutors.add(new FrontTutor(++ID, "Роксана", "З", "Сейчас учится на Java-разработчика", 46, "Санкт-Петербург", "@Roks", "roksana@gmail.com"));
    }

    public List<FrontTutor> frontTutorList() { return frontTutors; }

    public void saveFrontTutor(FrontTutor frontTutor) {
        frontTutor.setId(++ID);
        frontTutors.add(frontTutor);
    }

    public void deleteFrontTutor(int id) {
        frontTutors.removeIf(frontTutor -> frontTutor.getId() == id);
    }

    public FrontTutor getFrontTutorById(int id) {
        for (FrontTutor frontTutor : frontTutors) {
            if (frontTutor.getId()==id) return frontTutor;
        }
        return null;
    }
}
