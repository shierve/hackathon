package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class Map {
	private Array<Street> vertical_streets;
	private Array<Street> horizontal_streets;
	private Array<Intersection> intersections;
	private Array<Car> cars;

	//SPRITE
	//generacio del mapa


	public Array<Street> getVertical_streets(){
		return vertical_streets;
	}

	public Array<Street> getHorizontal_streets(){
		return horizontal_streets;
	}

	public Array<Intersection> getIntersections(){
		return intersections;
	}

	public Array<Car> getCars(){
		return cars;
	}

	private void addIntersection(double x, double y, Street h, Street v){
		Intersection i = new Intersection(x, y, h, v);
		intersections.add(i);
	}

	private void addIntersections(Street s){
		Array<Street> a = (s.isVertical() ? horizontal_streets : vertical_streets);
		for(int i = 0; i < a.size; ++i){
			double x = (s.isVertical() ? s.getPosition() : a.get(i).getPosition());
			double y = (s.isVertical() ? a.get(i).getPosition() : s.getPosition());
			addIntersection(x, y, (s.isVertical() ? a.get(i) : s), (s.isVertical() ? s : a.get(i)));
		}
	}

	public void addStreet(boolean vertical, double position){
		Street s = new Street(vertical, position);
		if(vertical) vertical_streets.add(s);
		else horizontal_streets.add(s);

		addIntersections(s);
	}

	public void addCar(Car c){
		cars.add(c);
	}
}
