package guiprototype2;

import javax.swing.BorderFactory;
import javax.swing.CellRendererPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;

import com.mxgraph.canvas.mxICanvas;
import com.mxgraph.canvas.mxImageCanvas;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.swing.handler.mxRubberband;
import com.mxgraph.swing.view.mxInteractiveCanvas;
import com.mxgraph.view.mxCellState;
import com.mxgraph.view.mxGraph;
import com.mxgraph.view.mxStylesheet;

public class NewEmpty extends JFrame
{
 mxGraph graph;
 mxGraphComponent graphComponent;
 mxStylesheet Stylesheet;
	/**
	 * 
	 */
	private static final long serialVersionUID = -844106998814982739L;

	public NewEmpty()
	{
		super("Custom Canvas");

		// Demonstrates the use of a Swing component for rendering vertices.
		// Note: Use the heavyweight feature to allow for event handling in
		// the Swing component that is used for rendering the vertex.

		graph = new mxGraph()
		{
			public void drawState(mxICanvas canvas, mxCellState state,
					boolean drawLabel)
			{
				String label = (drawLabel) ? state.getLabel() : "";

				// Indirection for wrapped swing canvas inside image canvas (used for creating
				// the preview image when cells are dragged)
				if (getModel().isVertex(state.getCell())
						&& canvas instanceof mxImageCanvas
						&& ((mxImageCanvas) canvas).getGraphicsCanvas() instanceof NewEmpty.SwingCanvas)
				{
					((NewEmpty.SwingCanvas) ((mxImageCanvas) canvas).getGraphicsCanvas())
							.drawVertex(state, label);
				}
				// Redirection of drawing vertices in SwingCanvas
				else if (getModel().isVertex(state.getCell())
						&& canvas instanceof NewEmpty.SwingCanvas)
				{
					((NewEmpty.SwingCanvas) canvas).drawVertex(state, label);
				}
				else
				{
					super.drawState(canvas, state, drawLabel);
				}
			}
		};

		Object parent = graph.getDefaultParent();

		graph.getModel().beginUpdate();
		try
		{

			Object v1 = graph.insertVertex(parent, null, "Hello", 100, 100, 40,
					40);
			Object v2 = graph.insertVertex(parent, null, "World!", 200, 100,
					40, 40);
                        Object v3 = graph.insertVertex(parent, null, "Vertex3", 100, 200,
					40, 40);
                        Object v4 = graph.insertVertex(parent, null, "Vertex4", 200, 200,
					40, 40);
			graph.insertEdge(parent, null, "Edge", v1, v2);
		}
		finally
		{
			graph.getModel().endUpdate();
		}

		//mxGraphComponent graphComponent = new mxGraphComponent(graph)
                graphComponent = new mxGraphComponent(graph)
		{
			/**
			 * 
			 */
			private static final long serialVersionUID = 4683716829748931448L;

			public mxInteractiveCanvas createCanvas()
			{
				return new NewEmpty.SwingCanvas(this);
			}
		};

		getContentPane().add(graphComponent);

		// Adds rubberband selection
		new mxRubberband(graphComponent);
	}

	public class SwingCanvas extends mxInteractiveCanvas
	{
		protected CellRendererPane rendererPane = new CellRendererPane();

		protected JLabel vertexRenderer = new JLabel();

		protected mxGraphComponent graphComponent;

		public SwingCanvas(mxGraphComponent graphComponent)
		{
			this.graphComponent = graphComponent;

			vertexRenderer.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.RAISED));
			vertexRenderer.setHorizontalAlignment(JLabel.CENTER);
			vertexRenderer.setBackground(graphComponent.getBackground()
					.darker());
			vertexRenderer.setOpaque(true);
		}

		public void drawVertex(mxCellState state, String label)
		{
			vertexRenderer.setText(label);
			// TODO: Configure other properties...

			rendererPane.paintComponent(g, vertexRenderer, graphComponent,
					(int) state.getX() + translate.x, (int) state.getY()
							+ translate.y, (int) state.getWidth(),
					(int) state.getHeight(), true);
		}

	}

	public static void main(String[] args)
	{
		NewEmpty frame = new NewEmpty();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 320);
		frame.setVisible(true);
	}

}
