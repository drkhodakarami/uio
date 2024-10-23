public static VoxelShape makeShape() {
	return VoxelShapes.union(
		VoxelShapes.cuboid(0.0625, 0, 0.0625, 0.9375, 0.125, 0.875),
		VoxelShapes.cuboid(0.1875, 0.125, 0.1875, 0.8125, 0.3125, 0.8125),
		VoxelShapes.cuboid(0.29374999999999996, 0.3125, 0.29374999999999984, 0.6999999999999996, 1, 0.6999999999999998)
	);
}