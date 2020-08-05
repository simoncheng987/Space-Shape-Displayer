package spaceshapes.views;

import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;

/**
 * Task 1 act as an adapter between the ShapeModel and the TreeModel Adapater
 * pattern is implemented.
 *
 * @author Simon Cheng
 *
 */
public class Task1 implements TreeModel {

	protected ShapeModel _model;
	protected List<TreeModelListener> _listener_list;

	public Task1(ShapeModel model) {
		_model = model;
		 _listener_list = new ArrayList<TreeModelListener>();
	}

	/**
	 * return _model's root
	 */
	@Override
	public Object getRoot() {
		// TODO Auto-generated method stub
		return _model.root();
	}
	
	
	/**
	 * return the index_th child in parent
	 */
	@Override
	public Object getChild(Object parent, int index) {
		// TODO Auto-generated method stub
		try {
			if (parent instanceof CarrierShape) {
				CarrierShape tempCarrierShape = (CarrierShape) parent;
				return tempCarrierShape.shapeAt(index);
			}
			return null;
		} catch (IndexOutOfBoundsException e) {
			// TODO: handle exception
			return null;
		}

	}
	
	/**
	 * return the number of children in a parent
	 */
	@Override
	public int getChildCount(Object parent) {
		// TODO Auto-generated method stub
		int count = 0;
		if (parent instanceof CarrierShape) {
			CarrierShape tempCarrierShape = (CarrierShape) parent;
			count = tempCarrierShape.shapeCount();
		}
		return count;
	}

	/**
	 * return true is if the node is not an instance of CarrierShape
	 */
	@Override
	public boolean isLeaf(Object node) {
		// TODO Auto-generated method stub
		return !(node instanceof CarrierShape);
	}

	/**
	 * return the index of a child given its parent
	 */
	@Override
	public int getIndexOfChild(Object parent, Object child) {
		// TODO Auto-generated method stub
		if (parent instanceof CarrierShape && child instanceof Shape) {
			CarrierShape tempCarrierShape = (CarrierShape) parent;
			Shape tempShape = (Shape) child;
			return tempCarrierShape.indexOf(tempShape);
		}
		return -1;
	}
	
	/**
	 * add a treeListener to the _listener_list
	 */
	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		_listener_list.add(l);
	}
	
	/**
	 * remove a treeListener from the _listener_list
	 */
	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		_listener_list.remove(l);
	}
	
	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// empty
	}

}
