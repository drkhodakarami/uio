public static VoxelShape makeShape() {
	return VoxelShapes.union(
		VoxelShapes.cuboid(0, 0, 0, 0.125, 0.125, 1),
		VoxelShapes.cuboid(0.875, 0, 0, 1, 0.125, 1),
		VoxelShapes.cuboid(0, 0.875, 0, 0.125, 1, 1),
		VoxelShapes.cuboid(0.875, 0.875, 0, 1, 1, 1),
		VoxelShapes.cuboid(0, 0.125, 0, 0.125, 0.875, 0.125),
		VoxelShapes.cuboid(0, 0.125, 0.875, 0.125, 0.875, 1),
		VoxelShapes.cuboid(0.875, 0.125, 0.875, 1, 0.875, 1),
		VoxelShapes.cuboid(0.875, 0.125, 0, 1, 0.875, 0.125),
		VoxelShapes.cuboid(0.125, 0, 0, 0.875, 0.125, 0.125),
		VoxelShapes.cuboid(0.125, 0, 0.875, 0.875, 0.125, 1),
		VoxelShapes.cuboid(0.125, 0.875, 0.875, 0.875, 1, 1),
		VoxelShapes.cuboid(0.125, 0.875, 0, 0.875, 1, 0.125),
		VoxelShapes.cuboid(0.375, 0.375, 0.375, 0.625, 0.625, 0.625),
		VoxelShapes.cuboid(0.375, 0, 0.375, 0.625, 0.03125, 0.625),
		VoxelShapes.cuboid(0.375, 0.9687500000000001, 0.375, 0.625, 0.9999999999999997, 0.625),
		VoxelShapes.cuboid(0, 0.375, 0.375, 0.03125, 0.625, 0.625),
		VoxelShapes.cuboid(0.9687500000000001, 0.375, 0.375, 0.9999999999999997, 0.625, 0.625),
		VoxelShapes.cuboid(0.375, 0.375, 0, 0.625, 0.625, 0.03125),
		VoxelShapes.cuboid(0.375, 0.375, 0.9687500000000001, 0.625, 0.625, 0.9999999999999997),
		VoxelShapes.cuboid(0.4687499999999999, 0.03125, 0.4687500000000001, 0.5312499999999999, 0.3749999999999999, 0.5312500000000001),
		VoxelShapes.cuboid(0.4687499999999999, 0.6249999999999999, 0.4687500000000001, 0.5312499999999999, 0.9687499999999998, 0.5312500000000001),
		VoxelShapes.cuboid(0.03125, 0.4687499999999999, 0.4687499999999999, 0.375, 0.5312499999999999, 0.5312499999999999),
		VoxelShapes.cuboid(0.6249999999999999, 0.4687499999999999, 0.4687499999999999, 0.9687499999999999, 0.5312499999999999, 0.5312499999999999),
		VoxelShapes.cuboid(0.4687499999999999, 0.4687499999999999, 0.03125, 0.5312499999999999, 0.5312499999999999, 0.375),
		VoxelShapes.cuboid(0.4687499999999999, 0.4687499999999999, 0.6249999999999999, 0.5312499999999999, 0.5312499999999999, 0.9687499999999999),
		VoxelShapes.cuboid(0.00625, 0.125, 0.125, 0.012499999999999999, 0.875, 0.875),
		VoxelShapes.cuboid(0.9875, 0.125, 0.125, 0.9937499999999999, 0.875, 0.875),
		VoxelShapes.cuboid(0.125, 0.125, 0.00625, 0.875, 0.875, 0.012499999999999992),
		VoxelShapes.cuboid(0.125, 0.125, 0.9875, 0.875, 0.875, 0.9937499999999999),
		VoxelShapes.cuboid(0.125, 0.00625, 0.125, 0.875, 0.0125, 0.875),
		VoxelShapes.cuboid(0.125, 0.9875, 0.125, 0.875, 0.9937499999999999, 0.875)
	);
}