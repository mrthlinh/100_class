package hibernate;
//ID = 1310603
import java.io.Serializable;
import javax.persistence.*;

import org.apache.directory.api.ldap.aci.UserClass.UserGroup;
import org.hibernate.annotations.ForeignKey;

public class hibernate_class_11 {


@Entity
@Table(name = "User")
public class User implements Serializable {

    private static final long serialVersionUID = 2209767646758652729L;

    @Id
    @Column(name="id", nullable = false)
    private Integer id;

    @Column(name="name", length = 200, nullable = true)
    private String name;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "groupId", nullable = false, insertable=false, updatable=false)
    @ForeignKey(name="FK_GroupId")
    private UserGroup userGroup;

    /* Getters, Setters, toString, equals & hashCode */
}
}
