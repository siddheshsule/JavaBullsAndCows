class Employee {

    // write fields
    String name;
    String email;
    int experience;

    // write constructor
    public Employee(String name, String email, int experience) {
        this.name = name;
        this.email = email;
        this.experience = experience;
    }

    // write getters
    public String getName() {
        return this.name;
    }

    public String getEmail() {
        return this.email;
    }

    public int getExperience() {
        return this.experience;
    }
}

class Developer extends Employee {

    String mainLanguage;
    String[] skills;

    // write constructor
    public Developer(String name, String email, int experience, String mainLanguage, String[] skills) {
        // write fields
        super(name, email, experience);
        this.mainLanguage = mainLanguage;
        this.skills = skills;
    }
    // write getters

    public String getMainLanguage() {
        return this.mainLanguage;
    }

    public String[] getSkills() {
        return this.skills;
    }
}

class DataAnalyst extends Employee {

    // write fields
    boolean phd;
    String[] methods;

    // write constructor
    public DataAnalyst(String name, String email, int experience, boolean phd, String[] methods) {
        super(name, email, experience);
        this.phd = phd;
        this.methods = methods;
    }

    public boolean isPhd() {
        return true;
    }

    public String[] getMethods() {
        return this.methods;
    }

    // write getters
}