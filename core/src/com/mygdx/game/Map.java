package com.mygdx.game;

import com.badlogic.gdx.utils.Array;

public class Map {
	private Array<Street> vertical_streets;
	private Array<Street> horizontal_streets;
	private Array<Intersection> intersections;
	private Array<Car> cars;


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

	private void addIntersection(double x, double y){
		Intersection i = new Intersection(x, y);
		intersections.add(i);
	}

	private void addIntersections(boolean vertical, double position){
		Array<Street> a = (vertical ? horizontal_streets : vertical_streets);
		for(int i = 0; i < a.size; ++i){
			double x = (vertical ? position : a.get(i).getPosition());
			double y = (vertical ? a.get(i).getPosition() : position);
			addIntersection(x, y);
		}
	}

	public void addStreet(boolean vertical, double position){
		Street s = new Street(vertical, position);
		if(vertical) vertical_streets.add(s);
		else horizontal_streets.add(s);

		addIntersections(vertical, position);
	}

	public void addCar(Car c){
		cars.add(c);
	}
}
