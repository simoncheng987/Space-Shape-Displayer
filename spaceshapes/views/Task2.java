package spaceshapes.views;

import java.util.List;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import spaceshapes.Shape;
import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelListener;

/**
 * The Task2 class has the following roles:
 * 
 * 1.act as the model of a JTree component, and the (non-visual) view(listener)
 * of a ShapeModel
 * 
 * 2.transforms ShapeModel events that it hears about into TreeModel events that
 * it fires to its TreeModelListeners.
 * 
 * @author Simon Cheng
 *
 */
public class Task2 extends Task1 implements ShapeModelListener {

	public Task2(ShapeModel model) {
		super(model);
	}

	/**
	 * By overriding the update method - convert a ShapeModelEvent to
	 * TreeModelEvent; then send to the TreeModelListener
	 */
	@Override
	public void update(ShapeModelEvent event) {

		// checks if _model is the shapeModel source that we want
		if (_model == event.source()) {
			Shape shape = event.operand();
			ShapeModelEvent.EventType eventType = event.eventType();
			Shape parent = event.parent();
			Object[] path_arr = null;

			Object[] children = { shape };
			int[] childIndices = { event.index() };

			if (parent == null) {
				path_arr = null;
			} else {
				List<Shape> path_temp = parent.path();
				path_arr = path_temp.toArray();
			}

			// Different EventType of a ShapeModelEvent calls different method
			if (eventType == ShapeModelEvent.EventType.ShapeAdded) {

				updateShapeAddedEvent(this, path_arr, childIndices, children);
			}

			if (eventType == ShapeModelEvent.EventType.ShapeRemoved) {

				updateShapeRemoveEvent(this, path_arr, childIndices, children);
			}

		}
	}

	/**
	 * method that invoked after a node has been removed from the tree.
	 */
	public void updateShapeRemoveEvent(Object source, Object[] path,
			int[] childIndices, Object[] children) {
		TreeModelEvent treeModelEvent = new TreeModelEvent(source, path,
				childIndices, children);
		for (TreeModelListener tml : _listener_list) {
			tml.treeNodesRemoved(treeModelEvent);
		}
	}

	/**
	 * method that invoked after a node has been added to the tree.
	 */
	public void updateShapeAddedEvent(Object source, Object[] path,
			int[] childIndices, Object[] children) {
		TreeModelEvent treeModelEvent = new TreeModelEvent(source, path,
				childIndices, children);
		for (TreeModelListener tml : _listener_list) {
			tml.treeNodesInserted(treeModelEvent);
		}
	}

}
