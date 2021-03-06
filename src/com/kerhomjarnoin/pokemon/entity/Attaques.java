package com.kerhomjarnoin.pokemon.entity;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.Entity;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.OneToOne;
import com.tactfactory.harmony.bundles.rest.annotation.Rest;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;

@Entity
@Rest
public class Attaques  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

	@Id
	@Column(type = Type.INTEGER, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private int id;
	
	@Column(type = Type.STRING)
	private String nom;
	
	@Column(type = Type.INTEGER)
	private int puissance;
	
	@Column(type = Type.INTEGER)
	private int precis;
	
	@OneToOne()
	@Column()
	private Types type;

    /**
     * Default constructor.
     */
    public Attaques() {

    }

     /**
     * Get the Id.
     * @return the id
     */
    public int getId() {
         return this.id;
    }
     /**
     * Set the Id.
     * @param value the id to set
     */
    public void setId(final int value) {
         this.id = value;
    }
     /**
     * Get the Nom.
     * @return the nom
     */
    public String getNom() {
         return this.nom;
    }
     /**
     * Set the Nom.
     * @param value the nom to set
     */
    public void setNom(final String value) {
         this.nom = value;
    }
     /**
     * Get the Puissance.
     * @return the puissance
     */
    public int getPuissance() {
         return this.puissance;
    }
     /**
     * Set the Puissance.
     * @param value the puissance to set
     */
    public void setPuissance(final int value) {
         this.puissance = value;
    }
     /**
     * Get the Precis.
     * @return the precis
     */
    public int getPrecis() {
         return this.precis;
    }
     /**
     * Set the Precis.
     * @param value the precis to set
     */
    public void setPrecis(final int value) {
         this.precis = value;
    }
     /**
     * Get the Type.
     * @return the type
     */
    public Types getType() {
         return this.type;
    }
     /**
     * Set the Type.
     * @param value the type to set
     */
    public void setType(final Types value) {
         this.type = value;
    }
    /**
     * This stub of code is regenerated. DO NOT MODIFY.
     * 
     * @param dest Destination parcel
     * @param flags flags
     */
    public void writeToParcelRegen(Parcel dest, int flags) {
        if (this.parcelableParents == null) {
            this.parcelableParents = new ArrayList<Parcelable>();
        }
        if (!this.parcelableParents.contains(this)) {
            this.parcelableParents.add(this);
        }
        dest.writeInt(this.getId());
        if (this.getNom() != null) {
            dest.writeInt(1);
            dest.writeString(this.getNom());
        } else {
            dest.writeInt(0);
        }
        dest.writeInt(this.getPuissance());
        dest.writeInt(this.getPrecis());
        if (this.getType() != null
                    && !this.parcelableParents.contains(this.getType())) {
            this.getType().writeToParcel(this.parcelableParents, dest, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
    }

    /**
     * Regenerated Parcel Constructor. 
     *
     * This stub of code is regenerated. DO NOT MODIFY THIS METHOD.
     *
     * @param parc The parcel to read from
     */
    public void readFromParcel(Parcel parc) {
        this.setId(parc.readInt());
        int nomBool = parc.readInt();
        if (nomBool == 1) {
            this.setNom(parc.readString());
        }
        this.setPuissance(parc.readInt());
        this.setPrecis(parc.readInt());
        this.setType((Types) parc.readParcelable(Types.class.getClassLoader()));
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public Attaques(Parcel parc) {
        // You can chose not to use harmony's generated parcel.
        // To do this, remove this line.
        this.readFromParcel(parc);

        // You can  implement your own parcel mechanics here.

    }

    /* This method is not regenerated. You can implement your own parcel mechanics here. */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // You can chose not to use harmony's generated parcel.
        // To do this, remove this line.
        this.writeToParcelRegen(dest, flags);
        // You can  implement your own parcel mechanics here.
    }

    /**
     * Use this method to write this entity to a parcel from another entity.
     * (Useful for relations)
     *
     * @param parent The entity being parcelled that need to parcel this one
     * @param dest The destination parcel
     * @param flags The flags
     */
    public synchronized void writeToParcel(List<Parcelable> parents, Parcel dest, int flags) {
        this.parcelableParents = new ArrayList<Parcelable>(parents);
        dest.writeParcelable(this, flags);
        this.parcelableParents = null;
    }

    @Override
    public int describeContents() {
        // This should return 0 
        // or CONTENTS_FILE_DESCRIPTOR if your entity is a FileDescriptor.
        return 0;
    }

    /**
     * Parcelable creator.
     */
    public static final Parcelable.Creator<Attaques> CREATOR
        = new Parcelable.Creator<Attaques>() {
        public Attaques createFromParcel(Parcel in) {
            return new Attaques(in);
        }
        
        public Attaques[] newArray(int size) {
            return new Attaques[size];
        }
    };

}
