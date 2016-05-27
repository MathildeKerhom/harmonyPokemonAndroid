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
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;

@Entity
public class TypeDePokemons  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

	@Id@
	Column(type = Type.LONG, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private long id;
	
	@Column(type = Type.STRING)
	private String nom;
	
	@Column(type = Type.INTEGER)
	private int attaque;
	
	@Column(type = Type.INTEGER)
	private int attaque_spe;
	
	@Column(type = Type.INTEGER)
	private int defence;
	
	@Column(type = Type.INTEGER)
	private int defence_spe;
	
	@Column(type = Type.INTEGER)
	private int vitesse;
	
	@Column(type = Type.INTEGER)
	private int pv;

    /**
     * Default constructor.
     */
    public TypeDePokemons() {

    }

    /**
     * @return the id
     */
    public long getId() {
         return this.id;
    }

    /**
     * @param value the id to set
     */
    public void setId(final long value) {
         this.id = value;
    }

    /**
     * @return the nom
     */
    public String getNom() {
         return this.nom;
    }

    /**
     * @param value the nom to set
     */
    public void setNom(final String value) {
         this.nom = value;
    }

    /**
     * @return the attaque
     */
    public int getAttaque() {
         return this.attaque;
    }

    /**
     * @param value the attaque to set
     */
    public void setAttaque(final int value) {
         this.attaque = value;
    }

    /**
     * @return the attaque_spe
     */
    public int getAttaque_spe() {
         return this.attaque_spe;
    }

    /**
     * @param value the attaque_spe to set
     */
    public void setAttaque_spe(final int value) {
         this.attaque_spe = value;
    }

    /**
     * @return the defence
     */
    public int getDefence() {
         return this.defence;
    }

    /**
     * @param value the defence to set
     */
    public void setDefence(final int value) {
         this.defence = value;
    }

    /**
     * @return the defence_spe
     */
    public int getDefence_spe() {
         return this.defence_spe;
    }

    /**
     * @param value the defence_spe to set
     */
    public void setDefence_spe(final int value) {
         this.defence_spe = value;
    }

    /**
     * @return the vitesse
     */
    public int getVitesse() {
         return this.vitesse;
    }

    /**
     * @param value the vitesse to set
     */
    public void setVitesse(final int value) {
         this.vitesse = value;
    }

    /**
     * @return the pv
     */
    public int getPv() {
         return this.pv;
    }

    /**
     * @param value the pv to set
     */
    public void setPv(final int value) {
         this.pv = value;
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
        dest.writeString(this.getNom());
        dest.writeInt(this.getAttaque());
        dest.writeInt(this.getAttaque_spe());
        dest.writeInt(this.getDefence());
        dest.writeInt(this.getDefence_spe());
        dest.writeInt(this.getVitesse());
        dest.writeInt(this.getPv());
        this.parcelableParents = null;    
    }

    /**
     * Regenerated Parcel Constructor. 
     *
     * This stub of code is regenerated. DO NOT MODIFY THIS METHOD.
     *
     * @param parc The parcel to read from
     */
    public void readFromParcel(Parcel parc) {
        this.setNom(parc.readString());
        this.setAttaque(parc.readInt());
        this.setAttaque_spe(parc.readInt());
        this.setDefence(parc.readInt());
        this.setDefence_spe(parc.readInt());
        this.setVitesse(parc.readInt());
        this.setPv(parc.readInt());
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public TypeDePokemons(Parcel parc) {
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
    public static final Parcelable.Creator<TypeDePokemons> CREATOR
        = new Parcelable.Creator<TypeDePokemons>() {
        public TypeDePokemons createFromParcel(Parcel in) {
            return new TypeDePokemons(in);
        }
        
        public TypeDePokemons[] newArray(int size) {
            return new TypeDePokemons[size];
        }
    };

}
