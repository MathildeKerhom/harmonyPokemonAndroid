package com.kerhomjarnoin.pokemon.entity;

import org.joda.time.format.ISODateTimeFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;
import org.joda.time.DateTime;

import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.Entity;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.OneToOne;

@Entity
public class Pokemons  implements Serializable , Parcelable {

    /** Parent parcelable for parcellisation purposes. */
    protected List<Parcelable> parcelableParents;

	@Id@
	Column(type = Type.LONG, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private long id;
	
	@Column(type = Type.STRING)
	private String surnom;
	
	@Column(type = Type.INTEGER)
	private int niveau;
	
	@Column(type = Type.DATETIME, locale = true)
	private DateTime capture;
	
	@OneToOne()
	@Column()
	private TypeDePokemons typePokemon;

    /**
     * Default constructor.
     */
    public Pokemons() {

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
     * @return the surnom
     */
    public String getSurnom() {
         return this.surnom;
    }

    /**
     * @param value the surnom to set
     */
    public void setSurnom(final String value) {
         this.surnom = value;
    }

    /**
     * @return the niveau
     */
    public int getNiveau() {
         return this.niveau;
    }

    /**
     * @param value the niveau to set
     */
    public void setNiveau(final int value) {
         this.niveau = value;
    }

    /**
     * @return the capture
     */
    public DateTime getCapture() {
         return this.capture;
    }

    /**
     * @param value the capture to set
     */
    public void setCapture(final DateTime value) {
         this.capture = value;
    }

    /**
     * @return the typePokemon
     */
    public TypeDePokemons getTypePokemon() {
         return this.typePokemon;
    }

    /**
     * @param value the typePokemon to set
     */
    public void setTypePokemon(final TypeDePokemons value) {
         this.typePokemon = value;
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
        dest.writeString(this.getSurnom());
        dest.writeInt(this.getNiveau());
        if (this.getCapture() != null) {
            dest.writeInt(1);
            dest.writeString(ISODateTimeFormat.dateTime().print(
                    this.getCapture()));
        } else {
            dest.writeInt(0);
        }
        if (this.getTypePokemon() != null
                    && !this.parcelableParents.contains(this.getTypePokemon())) {
            this.getTypePokemon().writeToParcel(this.parcelableParents, dest, flags);
        } else {
            dest.writeParcelable(null, flags);
        }
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
        this.setSurnom(parc.readString());
        this.setNiveau(parc.readInt());
        if (parc.readInt() == 1) {
            this.setCapture(
                    ISODateTimeFormat.dateTimeParser()
                            .withOffsetParsed().parseDateTime(
                                    parc.readString()));
        }
        this.setTypePokemon((TypeDePokemons) parc.readParcelable(TypeDePokemons.class.getClassLoader()));
    }

    /**
     * Parcel Constructor.
     *
     * @param parc The parcel to read from
     */
    public Pokemons(Parcel parc) {
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
    public static final Parcelable.Creator<Pokemons> CREATOR
        = new Parcelable.Creator<Pokemons>() {
        public Pokemons createFromParcel(Parcel in) {
            return new Pokemons(in);
        }
        
        public Pokemons[] newArray(int size) {
            return new Pokemons[size];
        }
    };

}
