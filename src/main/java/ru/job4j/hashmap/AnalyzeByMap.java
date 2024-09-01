package ru.job4j.hashmap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class AnalyzeByMap {

    /**
     * Вычисляет общий средний балл.
     *
     * @param pupils Список учеников.
     * @return Общий средний балл.
     */
    public static double averageScore(List<Pupil> pupils) {
        int totalScore = 0;
        int totalSubjects = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
                totalSubjects++;
            }
        }
        return totalSubjects == 0 ? 0 : (double) totalScore / totalSubjects;
    }

    /**
     * Вычисляет средний балл по каждому ученику.
     *
     * @param pupils Список учеников.
     * @return Возвращает список объектов Label (имя ученика и суммарный балл).
     */
    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> averageScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalPupilScore = 0;
            List<Subject> subjects = pupil.subjects();
            for (Subject subject : subjects) {
                totalPupilScore += subject.score();
            }
            double averagePupilScore = subjects.isEmpty() ? 0
                    : (double) totalPupilScore / subjects.size();
            averageScores.add(new Label(pupil.name(), averagePupilScore));
        }
        return averageScores;
    }

    /**
     * Вычисляет средний балл по каждому предмету.
     *
     * @param pupils Список учеников.
     * @return Возвращает список объектов Label (название предмета и средний балл).
     */
    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScoresSum = new LinkedHashMap<>();
        Map<String, Integer> subjectCount = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                subjectScoresSum.put(subjectName,
                        subjectScoresSum.getOrDefault(subjectName, 0) + subject.score());
                subjectCount.put(subjectName,
                        subjectCount.getOrDefault(subjectName, 0) + 1);
            }
        }
        List<Label> averageScores = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScoresSum.entrySet()) {
            int count = subjectCount.get(entry.getKey());
            double averageSubjectScore = count == 0 ? 0
                    : (double) entry.getValue() / count;
            averageScores.add(new Label(entry.getKey(), averageSubjectScore));
        }
        return averageScores;
    }

    /**
     * Определяет лучшего ученика.
     *
     * @param pupils Список учеников.
     * @return Возвращает объект Label (имя ученика и суммарный балл).
     */
    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> pupilsSumScores = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            pupilsSumScores.add(new Label(pupil.name(), totalScore));
        }
        Label bestStudent = null;
        double maxScore = 0;
        for (Label label : pupilsSumScores) {
            if (label.score() > maxScore) {
                maxScore = label.score();
                bestStudent = label;
            }
        }
        return bestStudent;
    }

    /**
     * Определяет предмет с наибольшим баллом для всех студентов.
     *
     * @param pupils Список учеников.
     * @return Возвращает объект Label
     * (имя предмета, сумма баллов каждого ученика по этому предмету).
     */
    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectScoresSum = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                String subjectName = subject.name();
                subjectScoresSum.put(subjectName,
                        subjectScoresSum.getOrDefault(subjectName, 0) + subject.score());
            }
        }
        List<Label> subjectsScores = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : subjectScoresSum.entrySet()) {
            subjectsScores.add(new Label(entry.getKey(), entry.getValue()));
        }
        Label bestSubject = null;
        double maxScore = 0;
        for (Label label : subjectsScores) {
            if (label.score() > maxScore) {
                maxScore = label.score();
                bestSubject = label;
            }
        }
        return bestSubject;
    }
}
