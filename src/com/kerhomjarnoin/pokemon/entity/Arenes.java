package com.kerhomjarnoin.pokemon.entity;

import com.tactfactory.harmony.annotation.Column;
import com.tactfactory.harmony.annotation.GeneratedValue;
import com.tactfactory.harmony.annotation.Id;
import com.tactfactory.harmony.annotation.Column.Type;
import com.tactfactory.harmony.annotation.GeneratedValue.Strategy;

public class Arenes {
	@Id@
	Column(type = Type.LONG, hidden = true)
    @GeneratedValue(strategy = Strategy.MODE_IDENTITY)
	private long id;
	
	@Column(type = Type.STRING)
	private String nom;
}
