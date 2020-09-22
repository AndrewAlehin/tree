package com.example.tree.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "objects")
public class Objects {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "uid")
    private String uid;

    @Column(name = "object_type")
    private int object_type;

    @Type(type = "jsonb")
    @Column(columnDefinition = "data")
    @Basic(fetch = FetchType.LAZY)
    private Name data;

    @Column(name = "parent_object_id")
    private long parent_object_id;

    public Objects() {
    }

    public Objects(long id, String uid, int object_type, Name data, long parent_object_id) {
        this.id = id;
        this.uid = uid;
        this.object_type = object_type;
        this.data = data;
        this.parent_object_id = parent_object_id;
    }

    @Override
    public String toString() {
        return "Objects{" +
                "id=" + id +
                ", uid='" + uid + '\'' +
                ", object_type=" + object_type +
                ", data=" + data +
                ", parent_object_id=" + parent_object_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Objects)) return false;
        Objects objects = (Objects) o;
        return id == objects.id &&
                object_type == objects.object_type &&
                parent_object_id == objects.parent_object_id &&
                java.util.Objects.equals(uid, objects.uid) &&
                java.util.Objects.equals(data, objects.data);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, uid, object_type, data, parent_object_id);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getObject_type() {
        return object_type;
    }

    public void setObject_type(int object_type) {
        this.object_type = object_type;
    }

    public Name getData() {
        return data;
    }

    public void setData(Name data) {
        this.data = data;
    }

    public long getParent_object_id() {
        return parent_object_id;
    }

    public void setParent_object_id(long parent_object_id) {
        this.parent_object_id = parent_object_id;
    }
}
