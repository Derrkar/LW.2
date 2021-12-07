package lab2;

import java.util.List;
import java.util.Objects;

public class Project {
    private String projectName;
    private List<Worker>workerList;

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectName() {
        return projectName;
    }

    public List<Worker> getWorkerList() {
        return workerList;
    }

    public void setWorkerList(List<Worker> list_1) {
        this.workerList = workerList;
    }

    public static class Builder {
        private Project newProject;

        public Builder() {
            newProject = new Project();
        }

        public Builder withProjectName(String name){
            newProject.projectName = name;
            return this;
        }

        public Builder withWorkerList(List<Worker> list){
            newProject.workerList = list;
            return this;
        }

        public Project build(){
            return newProject;
        }

    }

    public static List<Worker> filter(List<Worker> list, String name){

        for(int i = list.size()-1; i >=0 ;i--){
            if(list.get(i).getName() == name) {
                list.remove(i);
            }
        }
        return list;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", workerList=" + workerList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return projectName.equals(project.projectName) && workerList.equals(project.workerList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectName, workerList);
    }
}
