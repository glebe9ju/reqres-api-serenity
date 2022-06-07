package in.reqres.model;

public class ReqresPojo {
    private String email;
    private String name;
    private String lastname;
    private String job;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    public static ReqresPojo getRequresPojo(String email,String name, String lastname,String job){
        ReqresPojo reqresPojo = new ReqresPojo();
        reqresPojo.setEmail(email);
        reqresPojo.setName(name);
        reqresPojo.setLastname(lastname);
        reqresPojo.setJob(job);
        return reqresPojo;
    }
}
