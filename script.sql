USE [Coffee_manager]
GO
/****** Object:  Table [dbo].[Drinks]    Script Date: 12/13/2021 12:10:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Drinks](
	[dID] [int] NOT NULL,
	[dName] [nvarchar](50) NULL,
	[dImage] [nvarchar](80) NULL,
 CONSTRAINT [PK_Drinks] PRIMARY KEY CLUSTERED 
(
	[dID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (1, N'Classic Hot Chocolate', N'image/ClassicHotChocolate.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (2, N'Bourbon Chocolate', N'image/ClassicHotChocolate.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (3, N'Earl grey Chocolate', N'image/ClassicHotChocolate.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (4, N'Chocolate Banana', N'image/ClassicHotChocolate.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (5, N'Tea bag', N'image/Teabag.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (6, N'Socha Milk', N'image/SochaMilk.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (7, N'Chai Tea Latte', N'image/ChaiTeaLatte.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (8, N'Cotton Chamomile', N'image/CottonChamomile.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (9, N'Cafe phin', N'image/Cafephin.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (11, N'Cotton Chamomile12', N'image/Cafephin.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (12, N'12', N'image/CottonChamomile.jpg')
INSERT [dbo].[Drinks] ([dID], [dName], [dImage]) VALUES (13, N'13', N'image/SochaMilk.jpg')
/****** Object:  Table [dbo].[Category]    Script Date: 12/13/2021 12:10:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Category](
	[cID] [int] NOT NULL,
	[cName] [nvarchar](50) NULL,
 CONSTRAINT [PK_Category] PRIMARY KEY CLUSTERED 
(
	[cID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Category] ([cID], [cName]) VALUES (1, N'gram')
INSERT [dbo].[Category] ([cID], [cName]) VALUES (2, N'ml')
INSERT [dbo].[Category] ([cID], [cName]) VALUES (3, N'cái')
/****** Object:  Table [dbo].[Total]    Script Date: 12/13/2021 12:10:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Total](
	[tID] [int] IDENTITY(1,1) NOT NULL,
	[dID] [int] NULL,
	[tQuantity] [float] NULL,
	[tdob] [date] NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Total] ON
INSERT [dbo].[Total] ([tID], [dID], [tQuantity], [tdob]) VALUES (59, 1, 1, CAST(0x58430B00 AS Date))
INSERT [dbo].[Total] ([tID], [dID], [tQuantity], [tdob]) VALUES (60, 2, 2, CAST(0x58430B00 AS Date))
INSERT [dbo].[Total] ([tID], [dID], [tQuantity], [tdob]) VALUES (61, 3, 3, CAST(0x58430B00 AS Date))
SET IDENTITY_INSERT [dbo].[Total] OFF
/****** Object:  Table [dbo].[Product]    Script Date: 12/13/2021 12:10:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[pID] [nchar](10) NOT NULL,
	[pName] [nvarchar](50) NULL,
	[pQuantity] [float] NULL,
	[cID] [int] NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[pID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'1         ', N'Chocolate', 1000, 2)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'10        ', N'Coffee ex', 1000, 1)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'2         ', N'Milk', 8100, 2)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'3         ', N'Rich', 750, 2)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'4         ', N'Bourbon', 900, 2)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'5         ', N'Earlgrey Tea', 986, 3)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'6         ', N'Puree banana', 1000, 2)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'7         ', N'Tea bag', 1000, 3)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'8         ', N'Chaitea', 1000, 2)
INSERT [dbo].[Product] ([pID], [pName], [pQuantity], [cID]) VALUES (N'9         ', N'Fami', 1000, 3)
/****** Object:  Table [dbo].[DrinksDetail]    Script Date: 12/13/2021 12:10:34 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DrinksDetail](
	[dID] [int] NULL,
	[pID] [nchar](10) NULL,
	[ddQuantity] [float] NULL,
	[ddID] [int] IDENTITY(1,1) NOT NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[DrinksDetail] ON
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (1, N'2         ', 100, 7)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (1, N'3         ', 10, 8)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (1, N'1         ', 40, 9)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (2, N'2         ', 100, 10)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (2, N'3         ', 10, 11)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (2, N'1         ', 40, 12)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (4, N'2         ', 100, 19)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (3, N'2         ', 100, 14)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (3, N'3         ', 10, 15)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (3, N'1         ', 40, 16)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (3, N'5         ', 1, 17)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (4, N'3         ', 10, 20)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (4, N'1         ', 40, 21)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (4, N'6         ', 20, 22)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (5, N'7         ', 1, 23)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (6, N'8         ', 30, 24)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (6, N'9         ', 1, 25)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (6, N'2         ', 100, 26)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (7, N'2         ', 100, 27)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (7, N'9         ', 1, 28)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (7, N'8         ', 40, 29)
INSERT [dbo].[DrinksDetail] ([dID], [pID], [ddQuantity], [ddID]) VALUES (2, N'4         ', 20, 18)
SET IDENTITY_INSERT [dbo].[DrinksDetail] OFF
/****** Object:  ForeignKey [FK_DrinksDetail_Drinks]    Script Date: 12/13/2021 12:10:34 ******/
ALTER TABLE [dbo].[DrinksDetail]  WITH CHECK ADD  CONSTRAINT [FK_DrinksDetail_Drinks] FOREIGN KEY([dID])
REFERENCES [dbo].[Drinks] ([dID])
GO
ALTER TABLE [dbo].[DrinksDetail] CHECK CONSTRAINT [FK_DrinksDetail_Drinks]
GO
/****** Object:  ForeignKey [FK_DrinksDetail_Product]    Script Date: 12/13/2021 12:10:34 ******/
ALTER TABLE [dbo].[DrinksDetail]  WITH CHECK ADD  CONSTRAINT [FK_DrinksDetail_Product] FOREIGN KEY([pID])
REFERENCES [dbo].[Product] ([pID])
GO
ALTER TABLE [dbo].[DrinksDetail] CHECK CONSTRAINT [FK_DrinksDetail_Product]
GO
/****** Object:  ForeignKey [FK_Product_Category]    Script Date: 12/13/2021 12:10:34 ******/
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_Category] FOREIGN KEY([cID])
REFERENCES [dbo].[Category] ([cID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_Category]
GO
/****** Object:  ForeignKey [FK_Total_Drinks]    Script Date: 12/13/2021 12:10:34 ******/
ALTER TABLE [dbo].[Total]  WITH CHECK ADD  CONSTRAINT [FK_Total_Drinks] FOREIGN KEY([dID])
REFERENCES [dbo].[Drinks] ([dID])
GO
ALTER TABLE [dbo].[Total] CHECK CONSTRAINT [FK_Total_Drinks]
GO
