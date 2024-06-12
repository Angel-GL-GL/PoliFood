CREATE TABLE Usuarios(
	userID SERIAL NOT NULL,
	userName varchar(50) NOT NULL,
	userEmail varchar(50) NOT NULL,
	userPhone varchar(10) NOT NULL,
	userPassword varchar(50) NOT NULL,
	CONSTRAINT pkUser PRIMARY KEY(userID)
);

CREATE TABLE Empleados(
	employeeID Integer NOT NULL,
	employeeType varchar(20) NOT NULL,
	employeeUserID Integer NOT NULL,
	CONSTRAINT pkEmployee PRIMARY KEY(employeeID),
	CONSTRAINT fkEmployeeUser FOREIGN KEY(employeeUserID)
		REFERENCES Usuarios(userID)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Productos(
	productID SERIAL NOT NULL,
	productName varchar(20) NOT NULL,
	productPrice numeric(10,2) NOT NULL,
	productQuantity Integer NOT NULL,
	productCategory varchar(20) NOT NULL,
	productImage varchar(50) NOT NULL,
	productDescription varchar(50) NOT NULL,
	CONSTRAINT pkProduct PRIMARY KEY(productID)
);

CREATE TABLE Pedidos(
	orderID SERIAL NOT NULL,
	orderDate varchar(20),
	orderAddress varchar(50) NOT NULL,
	orderState varchar(15) NOT NULL DEFAULT 'Pendiente',
	orderTotal numeric(10,2) NOT NULL DEFAULT 0.0,	
	orderDeliveredDate varchar(20) NOT NULL DEFAULT '-',
	orderExtraInfo varchar(100) NOT NULL DEFAULT ' ',
	orderUserID Integer NOT NULL,
	CONSTRAINT pkOrder PRIMARY KEY(orderID),
	CONSTRAINT fkOrderUser FOREIGN KEY(orderUserID)
		REFERENCES Usuarios(userID)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Contenidos(
	containsID SERIAL NOT NULL,
	containsOrderID Integer NOT NULL,
	containsProductID Integer NOT NULL,
	containsQuantity Integer NOT NULL,
	CONSTRAINT pkContains PRIMARY KEY(containsID, containsOrderID),
	constraint fkContainsOrder FOREIGN KEY(containsOrderID)
		REFERENCES Pedidos(orderID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	constraint fkContainsProduct FOREIGN KEY(containsProductID)
		REFERENCES Productos(productID)
		ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Asignados(
	assignedID SERIAL NOT NULL,
	assignedEmployeeID Integer NOT NULL,
	assignedOrderID Integer NOT NULL,
	assignedDate varchar(20) NOT NULL,
	CONSTRAINT pkAssigned PRIMARY KEY(assignedID),
	CONSTRAINT fkAssignedEmployee FOREIGN KEY(assignedEmployeeID)
		REFERENCES Empleados(employeeID)
		ON UPDATE CASCADE ON DELETE CASCADE,
	constraint fkAssignedOrder FOREIGN KEY(assignedOrderID)
		REFERENCES Pedidos(orderID)
		ON UPDATE CASCADE ON DELETE CASCADE
);