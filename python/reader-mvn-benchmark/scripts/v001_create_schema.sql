CREATE TABLE if not exists benchmark_data (
	id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
	input_lenght INTEGER NOT NULL,
	input_type TEXT NOT NULL,
	algorithm TEXT NOT NULL,
	score REAL NOT NULL,
	error REAL NOT NULL
);
