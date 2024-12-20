public static VoxelShape makeShape() {
	return VoxelShapes.union(
		VoxelShapes.cuboid(0.0003125, 0, 0.0003125, 0.9996875000000001, 0.0625, 0.9996875000000001),
		VoxelShapes.cuboid(0, 0.375, 0.9375, 1, 0.5, 1),
		VoxelShapes.cuboid(0, 0.375, 0, 1, 0.5, 0.0625),
		VoxelShapes.cuboid(0.9375, 0.375, 0.0625, 1, 0.5, 0.9375),
		VoxelShapes.cuboid(0, 0.375, 0.0625, 0.0625, 0.5, 0.9375),
		VoxelShapes.cuboid(0.0625, 0.125, 0.0624375, 0.9375, 0.1875, 0.06249999999999999),
		VoxelShapes.cuboid(0.0624375, 0.125, 0.0625, 0.06249999999999999, 0.1875, 0.9375),
		VoxelShapes.cuboid(0.0625, 0.125, 0.9375625, 0.9375, 0.1875, 0.9376249999999999),
		VoxelShapes.cuboid(0.9375625, 0.125, 0.0625, 0.9376249999999999, 0.1875, 0.9375),
		VoxelShapes.cuboid(0.0624375, 0.3125, 0.0625, 0.06249999999999999, 0.375, 0.9375),
		VoxelShapes.cuboid(0.0625, 0.3125, 0.9375625, 0.9375, 0.375, 0.9376249999999999),
		VoxelShapes.cuboid(0.0625, 0.3125, 0.0624375, 0.9375, 0.375, 0.0624375),
		VoxelShapes.cuboid(0.9375625, 0.3125, 0.0625, 0.9376249999999999, 0.375, 0.9375),
		VoxelShapes.cuboid(0, 0.0003125, 0, 0.0625, 0.1253125, 1),
		VoxelShapes.cuboid(0.9375, 0.0003125, 0, 1, 0.1253125, 1),
		VoxelShapes.cuboid(0.0625, 0.0003125, 0.9375, 0.9375, 0.1253125, 1),
		VoxelShapes.cuboid(0.0625, 0.0003125, 0, 0.9375, 0.1253125, 0.0625),
		VoxelShapes.cuboid(0.0625, 0.1875, 0, 0.9375, 0.3125, 0.0625),
		VoxelShapes.cuboid(0.0625, 0.1875, 0.9375, 0.9375, 0.3125, 1),
		VoxelShapes.cuboid(0, 0.1875, 0.0625, 0.0625, 0.3125, 0.9375),
		VoxelShapes.cuboid(0.9375, 0.1875, 0.0625, 1, 0.3125, 0.9375),
		VoxelShapes.cuboid(0, 0.125, 0, 0.0625, 0.375, 0.0625),
		VoxelShapes.cuboid(0, 0.125, 0.9375, 0.0625, 0.375, 1),
		VoxelShapes.cuboid(0.9375, 0.125, 0.9375, 1, 0.375, 1),
		VoxelShapes.cuboid(0.9375, 0.125, 0, 1, 0.375, 0.0625),
		VoxelShapes.cuboid(0.0628125, 0.3125, 0.0628125, 0.9371875000000001, 0.375, 0.9371875000000001)
	);
}